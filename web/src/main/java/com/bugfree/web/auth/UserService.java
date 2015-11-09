package com.bugfree.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.stereotype.Service;

@Service
public class UserService implements SocialUserService {

	@Autowired
	private UserDao userRepo;

	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

	@Override
	public User loadUserByUserId(String userId)  {
		final User user = userRepo.findOne(userId).get();
		return checkUser(user);
	}

	@Override
	public User loadUserByUsername(String username) {
		final User user = userRepo.findByUsername(username);
		return checkUser(user);
	}

	@Override
	public User loadUserByConnectionKey(ConnectionKey connectionKey) {
		final User user = userRepo.findByProviderIdAndProviderUserId(connectionKey.getProviderId(), connectionKey.getProviderUserId());
		return checkUser(user);
	}

	@Override
	public void updateUserDetails(User user) {
		userRepo.save(user);
	}

	private User checkUser(User user) {
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		detailsChecker.check(user);
		return user;
	}
}

package com.bugfree.web.auth;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

@Service
public class TokenAuthenticationService {

	private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
	private static final long TEN_DAYS = 1000 * 60 * 60 * 24 * 10;

	private final TokenHandler tokenHandler;

	public TokenAuthenticationService() {
		 String secret = "dfsafjewofjdkljr23oiue03iowjdklwejqeoidjskqw";
		tokenHandler = new TokenHandler(DatatypeConverter.parseBase64Binary(secret));
	}

	public String getToken(UserAuthentication authentication) {
		final User user = authentication.getDetails();
		user.setExpires(System.currentTimeMillis() + TEN_DAYS);
		return tokenHandler.createTokenForUser(user);
	}

	public UserAuthentication getAuthentication(HttpServletRequest request) {
		// to prevent CSRF attacks we still only allow authentication using a custom HTTP header
		// (it is up to the client to read our previously set cookie and put it in the header)
		final String token = request.getHeader(AUTH_HEADER_NAME);
		if (token != null) {
			final User user = tokenHandler.parseUserFromToken(token);
			if (user != null) {
				return new UserAuthentication(user);
			}
		}
		return null;
	}
}

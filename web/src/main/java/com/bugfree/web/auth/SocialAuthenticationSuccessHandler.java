package com.bugfree.web.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SocialAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	@Autowired
	private SocialUserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		// Lookup the complete User object from the database and create an Authentication for it
		final User authenticatedUser = userService.loadUserByUsername(authentication.getName());

		// Add UserAuthentication to the response
		final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser);
		tokenAuthenticationService.addAuthentication(response, userAuthentication);
		response.sendRedirect("http://beaconic.herokuapp.com");
		super.onAuthenticationSuccess(request, response, authentication);
	}
}

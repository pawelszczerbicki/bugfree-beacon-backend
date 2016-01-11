package com.bugfree.web.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.util.HashSet;
import java.util.Set;

@Document
public class User implements SocialUserDetails {

	@Id
	private String id;

	@JsonIgnore
	private String providerId;

	@JsonIgnore
	private String providerUserId;

	@JsonIgnore
	private String accessToken;

	private String username;

	private String password;

	private long expires;

	private boolean accountExpired;

	private boolean accountLocked;

	private boolean credentialsExpired;

	private boolean accountEnabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	@JsonIgnore
	public String getUserId() {
		return id.toString();
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	@JsonIgnore
	public Set<SimpleGrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> auth = new HashSet<>();
		auth.add(new SimpleGrantedAuthority("USER"));
		auth.add(new SimpleGrantedAuthority("ADMIN"));
		return auth;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return !accountExpired;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return !accountEnabled;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getUsername();
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		throw new IllegalStateException("password should never be used");
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

package com.nitya.rest.users.security;

import java.io.Serial;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nitya.rest.users.entity.User;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 6527488193717761382L;
	private final String name;
	private final String password;
	private final List<GrantedAuthority> authorities;

	public CustomUserDetails(User user) {
		name = user.getUsername();
		password = user.getPassword();
		authorities = Arrays.stream(",".split(user.getRole())).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
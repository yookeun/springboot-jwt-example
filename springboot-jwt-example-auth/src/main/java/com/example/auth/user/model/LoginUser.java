package com.example.auth.user.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class LoginUser implements UserDetails {
	
	private static final long serialVersionUID = 6396079419309274853L;
	private Long id;
	private String username;
	private String password;
	private String userType;
	private List<String> roles;
	
	public LoginUser() {		
	}
	
	public LoginUser(User user) {
		this.id = user.getId();
		this.username =  user.getUserName();
		this.password = user.getPassword();
		this.userType = user.getUserType();		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
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

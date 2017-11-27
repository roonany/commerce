package com.rsupport.commerce.security;

import com.rsupport.commerce.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Getter
public class CustomUserDetails implements UserDetails {
 private Long id;
 private String username;
 private String password;
 private Set<GrantedAuthority> authorities;

 public CustomUserDetails(User user) {
   this.id = user.getId();
   this.username = user.getUsername();
   this.password = user.getPassword();
   authorities = new HashSet<>();
   authorities.addAll(user.getAuthorities());
 }

 @Override public boolean isAccountNonExpired() { return true; }
 @Override public boolean isAccountNonLocked() { return true; }
 @Override public boolean isCredentialsNonExpired() { return true; }
 @Override public boolean isEnabled() { return true; }
}
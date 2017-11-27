package com.rsupport.commerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


  @Bean
  public UserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
  }

  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
          .antMatchers("/resources/**", "/signup", "/about", "/storage/**").permitAll()
          .antMatchers("/api/**").hasAuthority("USER")
          .antMatchers("/admin/**").hasAuthority("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .defaultSuccessUrl("/login/success")
    ;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

}


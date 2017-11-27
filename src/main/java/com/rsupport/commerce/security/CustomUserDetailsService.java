package com.rsupport.commerce.security;

import com.rsupport.commerce.dao.UserDao;
import com.rsupport.commerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class CustomUserDetailsService implements UserDetailsService {

 @Autowired
 private UserDao userDao;

 @Override
 @Transactional(readOnly=true)
 public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   User user = userDao.findByUsername(username);
   return new CustomUserDetails(user);
 }
}

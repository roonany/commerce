package com.rsupport.commerce.dao;

import com.rsupport.commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends  JpaRepository<User, Long> {
 User findByUsername(String username);
}
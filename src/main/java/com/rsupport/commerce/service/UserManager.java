package com.rsupport.commerce.service;

import com.rsupport.commerce.model.User;

public interface UserManager {
    boolean existUserByUsername(String userName);
    User save(User user);
    User findByUsername(String userName);
}

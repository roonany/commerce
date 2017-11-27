package com.rsupport.commerce.service;

import com.rsupport.commerce.dao.UserDao;
import com.rsupport.commerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userManager")
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean existUserByUsername(String userName) {
        return findByUsername(userName) != null;
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findByUsername(String userName) {
        return userDao.findByUsername(userName);
    }
}

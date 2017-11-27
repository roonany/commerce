package com.rsupport.commerce.service;

import com.rsupport.commerce.dao.AuthorityDao;
import com.rsupport.commerce.dao.UserDao;
import com.rsupport.commerce.model.Authority;
import com.rsupport.commerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authorityManager")
public class AuthorityManagerImpl implements AuthorityManager {

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public Authority findByAuthority(String name) {
        return null;
    }
}

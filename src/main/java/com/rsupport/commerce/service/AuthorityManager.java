package com.rsupport.commerce.service;

import com.rsupport.commerce.model.Authority;

public interface AuthorityManager {
    Authority findByAuthority(String name);
}

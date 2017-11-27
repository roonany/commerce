package com.rsupport.commerce.dao;

import com.rsupport.commerce.model.Authority;
import com.rsupport.commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDao extends  JpaRepository<Authority, Long> {
 Authority findByAuthority(String name);
}
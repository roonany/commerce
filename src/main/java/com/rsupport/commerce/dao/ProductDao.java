package com.rsupport.commerce.dao;

import com.rsupport.commerce.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
    void findByOrderByCreatedDateDesc(Pageable pageable);
}

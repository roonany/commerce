package com.rsupport.commerce.service;

import com.rsupport.commerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductManager {
    Page<Product> findProducts(Pageable pageable);

    Product findOne(Long id);
}

package com.rsupport.commerce.service;

import com.rsupport.commerce.dao.ProductDao;
import com.rsupport.commerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("productManager")
public class ProductManagerImpl implements ProductManager{

    @Autowired
    private ProductDao productDao;

    @Override
    public Page<Product> findProducts(Pageable pageable) {
        productDao.findByOrderByCreatedDateDesc(pageable);
        return null;
    }

    @Override
    public Product findOne(Long id) {
        return productDao.findOne(id);
    }
}

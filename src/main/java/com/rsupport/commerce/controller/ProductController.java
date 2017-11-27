package com.rsupport.commerce.controller;

import com.rsupport.commerce.model.Product;
import com.rsupport.commerce.service.ProductManager;
import com.rsupport.commerce.vo.DataListRequestVO;
import com.rsupport.commerce.vo.DataListResponseVO;
import com.rsupport.commerce.vo.DataResponseVO;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CommonsLog
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @GetMapping
    public DataListResponseVO<Product> list(DataListRequestVO requestVO) {
        Page<Product> page = productManager.findProducts(requestVO.getPageable());
        return new DataListResponseVO<Product>(page);
    }

    @GetMapping(value = "/{id}")
    public DataResponseVO<Product> detail(@PathVariable Long id) {
        Product product = productManager.findOne(id);
        return new DataResponseVO<Product>(product);
    }

}

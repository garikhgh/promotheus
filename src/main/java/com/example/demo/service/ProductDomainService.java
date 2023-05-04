package com.example.demo.service;

import com.example.demo.dto.ProductDto;


public interface ProductDomainService {
    ProductDto persistProduct(ProductDto productDto);
}

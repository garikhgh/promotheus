package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.Map;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements ProductDomainService {


    private final ProductCounterService productCounterService;
    private final ProductRepository productRepository;
    private final Map map;


    @Override
    public ProductDto persistProduct(ProductDto productDto) {
        log.info("Saving product {}", productDto.getName());
        Product savedProduct = productRepository.save(map.toProduct(productDto));
        log.info("Product is already saved {}, the product quantity is {}", savedProduct.getName(), ProductCounterService.getProductCountSize());
        return map.fromProduct(savedProduct);
    }
}

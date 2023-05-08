package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.Map;
import com.example.demo.metrics.MetricServiceCounter;
import com.example.demo.repository.ProductRepository;
import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements ProductDomainService {


    private final ProductCounterService productCounterService;
    private final MetricServiceCounter metricServiceCounter;
    private final ProductRepository productRepository;
    private final Map map;


    @Override
    public ProductDto persistProduct(ProductDto productDto) {
        log.info("Saving product {}", productDto.getName());
        Product savedProduct = productRepository.save(map.toProduct(productDto));
        log.info("Product is already saved {}, the product quantity is {}", savedProduct.getName(), ProductCounterService.getProductCountSize());
        return map.fromProduct(savedProduct);
    }
    @Override
    public ProductDto postProduct(ProductDto productDto) {
        var productExist = productRepository.findProductByNameAndAndDescription(productDto.getName(), productDto.getDescription());
        if (productExist.isEmpty()) {
            log.info("Saving product {}", productDto.getName());
            var productToSave = map.toProduct(productDto);
            var savedProduct = productRepository.save(productToSave);
            metricServiceCounter.processRequest();
            log.info("Product is already saved {}, the product quantity is {}", savedProduct.getName(), ProductCounterService.getProductCountSize());
            return map.fromProduct(savedProduct);
        }
        log.info("The product {} exists.", productDto.getName());
        return productDto;
    }
}

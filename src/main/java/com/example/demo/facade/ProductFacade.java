package com.example.demo.facade;

import com.example.demo.dto.ProductDto;
import com.example.demo.response.ErrorCategory;
import com.example.demo.response.ResponseMessage;
import com.example.demo.service.ProductCounterService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductFacade implements ProductUniquenessFacade {

     private final ProductService productService;


     @Override
     public ResponseMessage countProducts(ProductDto productDto) {
          log.info("Checking if the product is unique in the in memory counter {}", productDto.getName());
          var productCounter = ProductCounterService.getProductCounter();

          if (!productCounter.contains(productDto.hashCode())) {
               log.info("Product is counted: product is in the db and in the inMemory counter: name={}", productDto.getName());
               var savedProduct = productService.persistProduct(productDto);
               return new ResponseMessage(ErrorCategory.UNIQUE.errorDto(), savedProduct, ProductCounterService.getProductCountSize());
          } else {
               log.warn("Product is not counted: product either no in the db or in the in memory counter: name={}", productDto.getName());
               return new ResponseMessage(ErrorCategory.DUPLICATED_PRODUCT.errorDto(), ProductCounterService.getProductCountSize());
          }
     }
}

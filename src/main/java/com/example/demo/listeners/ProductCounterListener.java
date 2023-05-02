package com.example.demo.listeners;

import com.example.demo.entity.Product;
import com.example.demo.mapper.Map;
import com.example.demo.service.ProductCounterService;
import jakarta.persistence.PostPersist;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductCounterListener {

     @PostPersist
     void postPersistProductCounter(Object productDto) {
          log.info("Trying to add the product into the inMemory db!");
          var counter = ProductCounterService.getProductCounter();
          if (productDto instanceof Product product) {
               var entity = Map.INSTANCE.fromProduct(product);
               counter.add(entity.hashCode());
               log.info("Product name={} is added into the inMemory db!", product.getName());
          }
     }
}

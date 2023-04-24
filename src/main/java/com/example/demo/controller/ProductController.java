package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.facade.ProductFacade;
import com.example.demo.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductFacade productFacade;

    @PostMapping("/create-product")
    public ResponseEntity<ResponseMessage> createProduct(@RequestBody ProductDto productDto) {
        log.info("Posting a new product with {} id", productDto.getName());
        var result = productFacade.isUniqueProduct(productDto);
        log.info("Posting is done with status {}", result.getHttpStatus());
        return ResponseEntity.status(result.getHttpStatus()).body(result);
    }

}

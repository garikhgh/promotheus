package com.example.demo.facade;

import com.example.demo.dto.ProductDto;
import com.example.demo.response.ResponseMessage;


public interface ProductUniquenessFacade {

     ResponseMessage countProducts(ProductDto productDto);


}

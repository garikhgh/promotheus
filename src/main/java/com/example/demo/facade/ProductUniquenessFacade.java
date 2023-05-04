package com.example.demo.facade;

import com.example.demo.dto.ProductDto;
import com.example.demo.response.ResponseMessage;


interface ProductUniquenessFacade {

    ResponseMessage countProducts(ProductDto productDto);

    ResponseMessage counter(ProductDto productDto);


}

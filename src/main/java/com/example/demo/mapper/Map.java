package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Map {
    Map INSTANCE = Mappers.getMapper(Map.class);

    @Mapping(target = "productId", ignore = true)
    Product toProduct(ProductDto productDto);

    ProductDto fromProduct(Product product);
}

package com.example.demo.response;

import com.example.demo.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ResponseMessage extends AbstractProductErrorResponse {


     @JsonProperty("body")
     private ProductDto body;

     @JsonProperty(value = "productCounter")
     private Number productCounter;

     public ResponseMessage(final ErrorDto error, Number productCounter) {
          super(error);
          this.productCounter = productCounter;
     }

     public ResponseMessage(final ErrorDto error, ProductDto body, int productCounter) {
          super(error);
          this.body = body;
          this.productCounter = productCounter;
     }

}

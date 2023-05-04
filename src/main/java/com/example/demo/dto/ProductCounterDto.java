package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCounterDto {

    @JsonProperty("counter")
    private int counter;

    @JsonProperty("createdAt")
    private Instant createdAt;

}

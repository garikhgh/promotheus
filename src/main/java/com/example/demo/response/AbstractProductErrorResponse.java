package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractProductErrorResponse {

    @JsonIgnore
    private Integer httpStatus;

    @JsonProperty("notification")
    private ErrorDto errors;

    protected AbstractProductErrorResponse(ErrorDto errorDto, Integer httpStatus) {
        this.httpStatus = httpStatus;
        this.errors = errorDto;
    }

    protected AbstractProductErrorResponse(ErrorDto errorDto) {
        this(errorDto, errorDto.getStatus().value());
    }

    protected AbstractProductErrorResponse() {
        this.httpStatus = 200;
        this.errors = new ErrorDto();
    }


}

package com.example.demo.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCategory {
    DUPLICATED_PRODUCT("Such a product exists already", HttpStatus.NOT_ACCEPTABLE),
    NAME_NOT_ALLOWED("The product name length should not be greater than 20", HttpStatus.INTERNAL_SERVER_ERROR),
    UNIQUE("The product is unique", HttpStatus.OK);

    private final String id;
    private final HttpStatus httpStatus;

    ErrorCategory(String s, HttpStatus httpStatus) {
        this.id = s;
        this.httpStatus = httpStatus;
    }
    public ErrorDto errorDto() {
        return new ErrorDto(getId(), name(), getHttpStatus());
    }
}

package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

    @JsonProperty("message")
    private String message;

    @JsonProperty("state")
    private String state;

    @JsonIgnore
    private HttpStatus status;
}

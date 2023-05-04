package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

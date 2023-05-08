package com.example.demo.exceptions;

import com.example.demo.response.ErrorCategory;
import com.example.demo.response.ResponseMessage;
import com.example.demo.service.ProductCounterService;
import org.hibernate.JDBCException;
import org.hibernate.query.QueryTypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlers {

    @ExceptionHandler(QueryTypeMismatchException.class)
    public ResponseEntity<ResponseMessage> queryTypeMismatchException(Exception exception) {
        var errorResult = new ResponseMessage(ErrorCategory.QUERY_TYPE_ERROR.errorDto(), ProductCounterService.getProductCountSize());
        return ResponseEntity.status(errorResult.getHttpStatus()).body(errorResult);
    }

    @ExceptionHandler(JDBCException.class)
    public ResponseEntity<ResponseMessage> internalServerExceptionsHandler(Exception exception) {
        var errorResult = new ResponseMessage(ErrorCategory.NAME_NOT_ALLOWED.errorDto(), ProductCounterService.getProductCountSize());
        return ResponseEntity.status(errorResult.getHttpStatus()).body(errorResult);
    }
}

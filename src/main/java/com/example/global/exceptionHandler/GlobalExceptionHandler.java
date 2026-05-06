package com.example.global.exceptionHandler;

import com.example.global.RS.RsData;
import com.example.global.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //400번 에러
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<RsData<Void>> handleServiceException(ServiceException e) {
        return ResponseEntity
                .badRequest()
                .body(new RsData<Void>(
                        "400",
                        e.getMessage()
                ));
    }

    //400번 에러
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RsData<Void>> handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();
        return ResponseEntity
                .badRequest()
                .body(
                        new RsData<Void>(
                                "400",
                                message
                        )
                );
    }
}

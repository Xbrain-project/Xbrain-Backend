package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.exception.BaseException;
import lombok.Data;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorAdviser {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e ){
        ErrorResponse response = new ErrorResponse();
        response.setErrorMassage(e.getMessage());
        response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED) ;
    }

    @Data
    public class ErrorResponse {
        private LocalDateTime timeStamp = LocalDateTime.now();
        private int status ;
        private String errorMassage ;
    }
}
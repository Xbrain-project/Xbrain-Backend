package com.Xbrain.BackendXbrain.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ErrorAdviser {

//    @ExceptionHandler(BaseException.class)
//    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
//        ErrorResponse response = new ErrorResponse();
//        response.setError(e.getMessage());
//        response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
//        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
//    }
//
//    @Data
//
//    public static class ErrorResponse {
//
//        private LocalDateTime timestamp = LocalDateTime.now();
//
//        private String error;
//
//        private int status;
//
//
//
//    }
}

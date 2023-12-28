package com.hospital.hospitalService.exception;

import com.hospital.hospitalService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse>  handlerResourceNotFoundException(ResourceNotFoundException exception){
        String massage=exception.getMessage();
      ApiResponse response=ApiResponse.builder().massage(massage).status(HttpStatus.NOT_FOUND).build();
      return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);

    }
}

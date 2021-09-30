package com.example.recipesbackend.error;

import com.example.recipesbackend.payload.response.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(final NotFoundException ex, final WebRequest request) {
        return new ResponseEntity(
                ApiError.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.BAD_REQUEST)
                        .errors(ex.getMessage())
                        .build(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST
        );
    }

}

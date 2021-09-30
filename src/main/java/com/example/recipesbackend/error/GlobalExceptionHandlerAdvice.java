package com.example.recipesbackend.error;

import com.example.recipesbackend.payload.response.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final List<Map<String, String>> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().parallelStream()
                .map(fieldError -> Collections.singletonMap(fieldError.getField(), fieldError.getDefaultMessage()))
                .forEach(errors::add);

        ex.getBindingResult().getGlobalErrors().parallelStream()
                .map(objectError -> Collections.singletonMap(objectError.getObjectName(), objectError.getDefaultMessage()))
                .forEach(errors::add);

        final ApiError error = new ApiError(HttpStatus.BAD_REQUEST, "Validation failed", errors);

        return handleExceptionInternal(ex, error, headers, error.getStatus(), request);
    }

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

package org.sample.products.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        final Map<String, String> body = ex.getBindingResult()
            .getAllErrors()
            .stream()
            .collect(Collectors.toMap(
                error -> String.format("%s.%s", error.getObjectName(), ((FieldError) error).getField()),
                error -> error.getDefaultMessage())
            );
        return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);
    }
}

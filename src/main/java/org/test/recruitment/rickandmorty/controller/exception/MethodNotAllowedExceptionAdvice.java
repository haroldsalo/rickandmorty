package org.test.recruitment.rickandmorty.controller.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.test.recruitment.rickandmorty.exception.handler.WebExceptionHandler;
import org.test.recruitment.rickandmorty.messaging.ResponseContainer;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MethodNotAllowedExceptionAdvice extends BaseExceptionAdvice {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseContainer<String>> handle(HttpServletRequest httpServletRequest, HttpRequestMethodNotSupportedException e) {
        errorLogging(httpServletRequest, e);
        return getResponseEntity(e);
    }

    private ResponseEntity<ResponseContainer<String>> getResponseEntity(HttpRequestMethodNotSupportedException e) {
        ResponseContainer<String> response = WebExceptionHandler.handle(e);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

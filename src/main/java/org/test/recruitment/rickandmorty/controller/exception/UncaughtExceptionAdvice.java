package org.test.recruitment.rickandmorty.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.test.recruitment.rickandmorty.exception.handler.WebExceptionHandler;
import org.test.recruitment.rickandmorty.messaging.ResponseContainer;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class UncaughtExceptionAdvice extends BaseExceptionAdvice {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ResponseContainer<String>> handle(HttpServletRequest httpServletRequest, Throwable t) {
        errorLogging(httpServletRequest, t);
        return getResponseEntity(t);
    }

    private ResponseEntity<ResponseContainer<String>> getResponseEntity(Throwable t) {
        ResponseContainer<String> response = WebExceptionHandler.handle(t);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

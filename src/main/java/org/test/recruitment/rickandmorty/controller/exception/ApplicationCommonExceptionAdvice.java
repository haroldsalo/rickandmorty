package org.test.recruitment.rickandmorty.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.test.recruitment.rickandmorty.exception.ApplicationCommonException;
import org.test.recruitment.rickandmorty.exception.handler.WebExceptionHandler;
import org.test.recruitment.rickandmorty.messaging.ResponseContainer;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationCommonExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationCommonExceptionAdvice.class);

    @ExceptionHandler(ApplicationCommonException.class)
    public ResponseEntity<ResponseContainer<String>> handle(ApplicationCommonException e) {
        return getResponseEntity(e);
    }

    private ResponseEntity<ResponseContainer<String>> getResponseEntity(ApplicationCommonException e) {
        logger.error("Exception: {}", e.getClass());
        ResponseContainer<String> response = WebExceptionHandler.handle(e);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

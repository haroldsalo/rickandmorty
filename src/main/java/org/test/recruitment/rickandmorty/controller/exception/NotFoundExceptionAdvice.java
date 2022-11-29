package org.test.recruitment.rickandmorty.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.test.recruitment.rickandmorty.exception.handler.WebExceptionHandler;
import org.test.recruitment.rickandmorty.messaging.ResponseContainer;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class NotFoundExceptionAdvice extends BaseExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(NotFoundExceptionAdvice.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ResponseContainer<String>> handle(NoHandlerFoundException e) {
        return getResponseEntity(e);
    }

    private ResponseEntity<ResponseContainer<String>> getResponseEntity(NoHandlerFoundException e) {
        logger.warn(e.getMessage());
        ResponseContainer<String> response = WebExceptionHandler.handle(e);
        return ResponseEntity.status(response.getCode()).body(response);
    }

}

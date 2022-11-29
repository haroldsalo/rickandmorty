package org.test.recruitment.rickandmorty.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.test.recruitment.rickandmorty.exception.ApplicationCommonException;
import org.test.recruitment.rickandmorty.messaging.ErrorNotificationBuilder;
import org.test.recruitment.rickandmorty.messaging.ResponseBuilder;
import org.test.recruitment.rickandmorty.messaging.ResponseContainer;
import org.test.recruitment.rickandmorty.messaging.ErrorNotification;

import java.util.UUID;

public class WebExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    private static final String FAILED_MESSAGE = "failed";

    // HTTP Status Code 400 Bad Request
    private static final int BAD_REQUEST_CODE = 400;
    // 400 Bad Request default error messages
    private static final String BAD_REQUEST_MESSAGE = "The server cannot or will not process the request due to an apparent client error.";
    private static final String REQUIRED_REQUEST_BODY_MESSAGE = "Malformed request syntax. Required request body is missing.";

    // HTTP Status Code 405 Method Not Allowed
    private static final int METHOD_NOT_ALLOWED_CODE = 405;
    // 405 Method Not Allowed default error message
    private static final String METHOD_NOT_ALLOWED_MESSAGE = "The request method is not supported for the requested resource.";

    // HTTP Status Code 404 Not Found
    private static final int NOT_FOUND_CODE = 404;
    // 404 Not Found default error message
    private static final String NOT_FOUND_MESSAGE = "Not Found";

    // HTTP Status Code 500 Internal Server Error
    private static final int INTERNAL_SERVER_ERROR_CODE = 500;
    // 500 Internal Server Error default error message
    private static final String UNCAUGHT_MESSAGE = "The application encountered an uncaught internal error and was unable to complete your request.";
    // For NullPointerException(s) message
    private static final String NULL_MESSAGE = "Maybe, an object referred by a null reference.";
    // Hide the public implicit one
    private WebExceptionHandler() {

    }

    public static ResponseContainer<String> handle(ApplicationCommonException e) {
        return new ResponseBuilder<String>()
                .setCode(e.getCode())
                .setMessage(FAILED_MESSAGE)
                .withErrors(new ErrorNotificationBuilder()
                        .setFamily(ErrorNotification.StatusFamily.CLIENT_ERROR)
                        .setContext(e)
                        .setIdentifier(e.getIdentifier())
                        .setDetails(e.getMessages())
                        .build())
                .build();
    }

    public static ResponseContainer<String> handle(HttpMessageNotReadableException e) {
        return new ResponseBuilder<String>()
                .setCode(BAD_REQUEST_CODE)
                .setMessage(FAILED_MESSAGE)
                .withErrors(new ErrorNotificationBuilder()
                        .setIdentifier(generateUUID())
                        .setFamily(ErrorNotification.StatusFamily.CLIENT_ERROR)
                        .setContext(e)
                        .addDetail(BAD_REQUEST_MESSAGE)
                        .addDetail(REQUIRED_REQUEST_BODY_MESSAGE)
                        .addDetail((e.getCause() == null) ? e.getMessage() : e.getCause().getLocalizedMessage())
                        .build())
                .build();
    }

    public static ResponseContainer<String> handle(HttpRequestMethodNotSupportedException e) {
        return new ResponseBuilder<String>()
                .setCode(METHOD_NOT_ALLOWED_CODE)
                .setMessage(FAILED_MESSAGE)
                .withErrors(new ErrorNotificationBuilder()
                        .setIdentifier(generateUUID())
                        .setFamily(ErrorNotification.StatusFamily.CLIENT_ERROR)
                        .setContext(e)
                        .addDetail(METHOD_NOT_ALLOWED_MESSAGE)
                        .addDetail(e.getMessage())
                        .build())
                .build();
    }

    public static ResponseContainer<String> handle(NoHandlerFoundException e) {
        String message = NOT_FOUND_MESSAGE + " " + e.getHttpMethod() + " " + e.getRequestURL();
        return new ResponseBuilder<String>()
                .setCode(NOT_FOUND_CODE)
                .setMessage(FAILED_MESSAGE)
                .withErrors(new ErrorNotificationBuilder()
                        .setIdentifier(generateUUID())
                        .setFamily(ErrorNotification.StatusFamily.CLIENT_ERROR)
                        .setContext(e)
                        .addDetail(message)
                        .build())
                .build();
    }

    public static ResponseContainer<String> handle(Throwable t) {
        String message = (t instanceof NullPointerException || t.getMessage() == null) ? NULL_MESSAGE : t.getMessage();
        return new ResponseBuilder<String>()
                .setCode(INTERNAL_SERVER_ERROR_CODE)
                .setMessage(FAILED_MESSAGE)
                .withErrors(new ErrorNotificationBuilder()
                        .setIdentifier(generateUUID())
                        .setFamily(ErrorNotification.StatusFamily.SERVER_ERROR)
                        .setContext(t)
                        .addDetail(UNCAUGHT_MESSAGE)
                        .addDetail(message)
                        .build())
                .build();
    }

    private static String generateUUID() {
        logger.error("Generating UUID for exception identifier...");
        String uuid = UUID.randomUUID().toString();
        logger.error("UUID: {}", uuid);
        return uuid;
    }

}


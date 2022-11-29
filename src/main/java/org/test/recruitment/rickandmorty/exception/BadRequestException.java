package org.test.recruitment.rickandmorty.exception;

import java.util.UUID;

/**
 * The mapper for this exception is @ApplicationCommonExceptionMapper
 * 
 * @author lcastill
 *
 */import java.util.List;

public class BadRequestException extends ApplicationCommonException {

	private static final long serialVersionUID = 1L;
	
	// HTTP Status Code 400 Bad Request
	private static final int CODE = 400;
	public BadRequestException(List<String> messages) {
        super(UUID.randomUUID().toString(), messages, CODE);
    }
	public BadRequestException(String message) {
		super(UUID.randomUUID().toString(), message, CODE);
    }
	
}
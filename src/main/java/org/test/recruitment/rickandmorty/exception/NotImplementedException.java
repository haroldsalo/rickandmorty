package org.test.recruitment.rickandmorty.exception;

import java.util.UUID;

/**
 * The mapper for this exception is @ApplicationCommonExceptionMapper
 * 
 * @author lcastill
 *
 */
public class NotImplementedException extends ApplicationCommonException {

	private static final long serialVersionUID = 1L;
	// (HTTP) 501 Not Implemented server error response code indicates that the
	// request method is not supported by the server and cannot be handled.
	private static final int CODE = 501;
	private static final String MESSAGE = "The request method is not supported by the server and cannot be handled.";

	public NotImplementedException(String message) {
        super(UUID.randomUUID().toString(), NotImplementedException.MESSAGE + " "  + message, CODE);
    }

	public NotImplementedException() {
        super(UUID.randomUUID().toString(), MESSAGE, CODE);
    }
	
}
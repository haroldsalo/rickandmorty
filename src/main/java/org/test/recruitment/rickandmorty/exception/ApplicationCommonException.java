package org.test.recruitment.rickandmorty.exception;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationCommonException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final int code;
	private final String identifier;
	private final List<String> messages;

	ApplicationCommonException(final String identifier, final List<String> messages, final int code) {
		// to print the exception message while printing the stacktrace
		super(identifier + " " + messages.stream()
				.map(s -> s.substring(0, s.length() - 1).concat("; "))
				.collect(Collectors.joining()));

		this.identifier = identifier;
		this.code = code;
		this.messages = messages;
	}
	
	ApplicationCommonException(final String identifier, final String message, final int code) {
		// to print the exception message while printing the stacktrace
		super(identifier + ": " + message);
		
		this.identifier = identifier;
		this.code = code;
		this.messages = Collections.singletonList(message);
	}

	public int getCode() {
		return code;
	}
	public List<String> getMessages() {
		return messages;
	}
	public String getIdentifier() {
		return identifier;
	}

}
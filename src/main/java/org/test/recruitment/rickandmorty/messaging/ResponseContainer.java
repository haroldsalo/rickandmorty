package org.test.recruitment.rickandmorty.messaging;

import java.util.Date;

/**
 * Generic class for custom responses.
 * 
 * @param <T> the type of the response body value.
 * @author lcastill
 */
public class ResponseContainer<T> {

	private Integer code;
	private String message;
	private Date date;
	private T data;
	private ErrorNotification errors;
	private String version;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	public ErrorNotification getErrors() {
		return errors;
	}

	public void setErrors(ErrorNotification errors) {
		this.errors = errors;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

package org.test.recruitment.rickandmorty.client.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdditionalInfo {

	@JsonProperty("name")
	private String name;
	@JsonProperty("url")
	private String url;
	
	/**
	 * Get name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get url
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Set url
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}

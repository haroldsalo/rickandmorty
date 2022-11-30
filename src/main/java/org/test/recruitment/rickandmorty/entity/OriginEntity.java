package org.test.recruitment.rickandmorty.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginEntity {

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("name")
	private String name;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("url")
	private String url;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("dimension")
	private String dimension;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("residents")
	private List<String> residents = null;

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("dimension")
	public String getDimension() {
		return dimension;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("dimension")
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("residents")
	public List<String> getResidents() {
		return residents;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("residents")
	public void setResidents(List<String> residents) {
		this.residents = residents;
	}

	@Override
	public String toString() {
		return "OriginEntity [name=" + name + ", url=" + url + ", dimension=" + dimension + ", residents=" + residents
				+ "]";
	}
	
	
}
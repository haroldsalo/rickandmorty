package org.test.recruitment.rickandmorty.client.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestOrigin {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("type")
	private String type;
	@JsonProperty("dimension")
	private String dimension;
	@JsonProperty("residents")
	private List<String> residents;
	@JsonProperty("url")
	private String url;
	@JsonProperty("created")
	private String created;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}
	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	/**
	 * @return the residents
	 */
	public List<String> getResidents() {
		return residents;
	}
	/**
	 * @param residents the residents to set
	 */
	public void setResidents(List<String> residents) {
		this.residents = residents;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "RestOrigin [id=" + id + ", name=" + name + ", type=" + type + ", dimension=" + dimension
				+ ", residents=" + residents + ", url=" + url + ", created=" + created + "]";
	}
	
	
}

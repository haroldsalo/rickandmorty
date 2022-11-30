package org.test.recruitment.rickandmorty.client.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestCharacter {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("status")
	private String status;
	@JsonProperty("species")
	private String species;
	@JsonProperty("type")
	private String type;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("origin")
	private AdditionalInfo origin;
	@JsonProperty("location")
	private AdditionalInfo location;
	@JsonProperty("image")
	private String image;
	@JsonProperty("episode")
	private String[] episode;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the origin
	 */
	public AdditionalInfo getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(AdditionalInfo origin) {
		this.origin = origin;
	}
	/**
	 * @return the location
	 */
	public AdditionalInfo getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(AdditionalInfo location) {
		this.location = location;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the episode
	 */
	public String[] getEpisode() {
		return episode;
	}
	/**
	 * @param episode the episode to set
	 */
	public void setEpisode(String[] episode) {
		this.episode = episode;
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
		return "RestCharacter [id=" + id + ", name=" + name + ", status=" + status + ", species=" + species + ", type="
				+ type + ", gender=" + gender + ", origin=" + origin.toString() + ", location=" + location.toString() + ", image=" + image
				+ ", episode=" + Arrays.toString(episode) + ", url=" + url + ", created=" + created + "]";
	}
	
}

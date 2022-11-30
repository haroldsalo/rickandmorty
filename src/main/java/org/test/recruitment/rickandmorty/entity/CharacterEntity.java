package org.test.recruitment.rickandmorty.entity;

import org.test.recruitment.rickandmorty.client.entity.RestCharacter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterEntity {

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("id")
	private Integer id;
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
	@JsonProperty("status")
	private String status;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("species")
	private String species;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("type")
	private String type;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("episode_count")
	private Integer episodeCount;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("origin")
	private OriginEntity origin;
	
	public CharacterEntity(RestCharacter restCharacter) {
		this.id = restCharacter.getId();
		this.name = restCharacter.getName();
		this.status = restCharacter.getStatus();
		this.species = restCharacter.getSpecies();
		this.type = restCharacter.getType();
		this.episodeCount = restCharacter.getEpisode().length;
	}
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

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
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("species")
	public String getSpecies() {
		return species;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("species")
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("episode_count")
	public Integer getEpisodeCount() {
		return episodeCount;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("episode_count")
	public void setEpisodeCount(Integer episodeCount) {
		this.episodeCount = episodeCount;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("origin")
	public OriginEntity getOrigin() {
		return origin;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("origin")
	public void setOrigin(OriginEntity origin) {
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "CharacterEntity [id=" + id + ", name=" + name + ", status=" + status + ", species=" + species
				+ ", type=" + type + ", episodeCount=" + episodeCount + ", origin=" + origin.toString() + "]";
	}
	
	
}
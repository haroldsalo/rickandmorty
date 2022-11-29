package org.test.recruitment.rickandmorty.service;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;
import org.test.recruitment.rickandmorty.entity.CharacterEntity;

public interface CharacterService {

	public CharacterEntity getCharacter(int code)throws RestClientException, URISyntaxException;
}

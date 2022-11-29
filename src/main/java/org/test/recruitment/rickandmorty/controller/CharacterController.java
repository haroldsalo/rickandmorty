package org.test.recruitment.rickandmorty.controller;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;
import org.test.recruitment.rickandmorty.entity.CharacterEntity;

public interface CharacterController {

	public CharacterEntity getCharacter(int code)throws RestClientException, URISyntaxException;
}

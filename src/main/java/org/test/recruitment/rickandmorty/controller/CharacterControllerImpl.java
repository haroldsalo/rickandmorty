package org.test.recruitment.rickandmorty.controller;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.test.recruitment.rickandmorty.entity.CharacterEntity;
import org.test.recruitment.rickandmorty.service.CharacterService;

@RestController
@RequestMapping("/api")
public class CharacterControllerImpl implements CharacterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CharacterControllerImpl.class);
	
	@Autowired
	private CharacterService service;
	
	@Override
    @GetMapping(
    	value = "/character/{code}",
    	produces = MediaType.APPLICATION_JSON_VALUE
    )
	@ResponseBody
    public CharacterEntity getCharacter(@PathVariable("code") int code) throws RestClientException, URISyntaxException {
		LOGGER.debug("[ CONSULTING ID ] {}", code);
        return service.getCharacter(code);
    }
}

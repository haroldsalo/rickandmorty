package org.test.recruitment.rickandmorty.service;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.test.recruitment.rickandmorty.client.RestClient;
import org.test.recruitment.rickandmorty.client.entity.RestCharacter;
import org.test.recruitment.rickandmorty.client.entity.RestOrigin;
import org.test.recruitment.rickandmorty.entity.CharacterEntity;
import org.test.recruitment.rickandmorty.entity.OriginEntity;

@Service
public class CharacterServiceImpl implements CharacterService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CharacterServiceImpl.class);
	
	@Autowired
	private RestClient restClient;
	
	@Value("${app.client.url}")
	private String url;
	
	@Override
	public CharacterEntity getCharacter(int code) throws RestClientException, URISyntaxException {
		RestCharacter restResponse =  restClient.getCharacter(code);
		LOGGER.debug("[ GETTING CHARACTER {} ] {}", code, restResponse.toString());
		CharacterEntity response = new CharacterEntity(restResponse);
		if(!"unknown".equals(restResponse.getOrigin().getName())) {
			RestOrigin restOrigin = restClient.getOriginByCharacter(restResponse.getOrigin().getUrl());
			LOGGER.debug("[ GETTING ORIGIN {} ] {}", restResponse.getOrigin().getUrl(), restOrigin.toString());
			response.setOrigin(new OriginEntity());
			response.getOrigin().setName(restOrigin.getName());
			response.getOrigin().setUrl(restOrigin.getUrl());
			response.getOrigin().setDimension(restOrigin.getDimension());
			response.getOrigin().setResidents(restOrigin.getResidents());
		}
		LOGGER.debug("[ FULL REQUIRED RESPONSE ] {}", response.toString());
		return response;
	}

}

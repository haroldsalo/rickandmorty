package org.test.recruitment.rickandmorty.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.test.recruitment.rickandmorty.client.RestClient;
import org.test.recruitment.rickandmorty.client.entity.RestCharacter;
import org.test.recruitment.rickandmorty.client.entity.RestOrigin;
import org.test.recruitment.rickandmorty.entity.CharacterEntity;
import org.test.recruitment.rickandmorty.entity.OriginEntity;

import ch.qos.logback.classic.Logger;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private Logger log;
	
	@Autowired
	private RestClient restClient;
	
	@Value("${app.client.url}")
	private String url;
	
	@Override
	public CharacterEntity getCharacter(int code) throws RestClientException, URISyntaxException {
		log.info("inicio");
		RestCharacter restResponse =  restClient.getCharacter(code);
		CharacterEntity response = new CharacterEntity(restResponse);
		if(!"unknown".equals(restResponse.getOrigin().getName())) {
			RestOrigin restOrigin = restClient.getOriginByCharacter(restResponse.getOrigin().getUrl());
			response.setOrigin(new OriginEntity());
			response.getOrigin().setName(restOrigin.getName());
			response.getOrigin().setUrl(restOrigin.getUrl());
			response.getOrigin().setDimension(restOrigin.getDimension());
			response.getOrigin().setResidents(restOrigin.getResidents());
		}
		log.info("fin");
		return response;
	}

}

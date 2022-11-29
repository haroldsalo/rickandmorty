package org.test.recruitment.rickandmorty.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.test.recruitment.rickandmorty.client.entity.RestCharacter;
import org.test.recruitment.rickandmorty.client.entity.RestOrigin;

@Component
public class RestClientImpl implements RestClient{
	
	@Value("${app.client.url}")
	private String baseUrl;
	
	@Override
	public RestCharacter getCharacter(int code) throws RestClientException, URISyntaxException {
		String url = String.format("%s/%s/%s", baseUrl, "character", code);
		return new RestTemplate().getForObject(new URI(url), RestCharacter.class);
	}
	
	@Override
	public RestOrigin getOriginByCharacter(String url) throws RestClientException, URISyntaxException {
		return new RestTemplate().getForObject(new URI(url), RestOrigin.class);
	}
}

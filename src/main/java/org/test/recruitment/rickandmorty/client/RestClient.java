package org.test.recruitment.rickandmorty.client;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;
import org.test.recruitment.rickandmorty.client.entity.RestCharacter;
import org.test.recruitment.rickandmorty.client.entity.RestOrigin;

public interface RestClient {

	public RestCharacter getCharacter(int code)throws RestClientException, URISyntaxException;
	public RestOrigin getOriginByCharacter(String url) throws RestClientException, URISyntaxException;
}

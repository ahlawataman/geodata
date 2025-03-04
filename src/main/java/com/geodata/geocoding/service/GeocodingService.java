package com.geodata.geocoding.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {
	
	private final String API_URL = "https://geodata.pythonanywhere.com/geocode";
	
	@Autowired
	private RestTemplate restTemplate;

	public Object geocode(String address) {
		
		String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("address", address)
                .toUriString();
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		
		return restTemplate.exchange(url, HttpMethod.GET, requestEntity, Object.class);
	}

	public String reversegeocode(String latitude, String longitude) {
		return "hello";
	}

}

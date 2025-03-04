package com.geodata.geocoding.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geodata.geocoding.service.GeocodingService;

@RestController
@RequestMapping("/v1")
public class GeocodingController {
	
	private GeocodingService geocodingService;
	
	public GeocodingController(GeocodingService geocodingService) {
		this.geocodingService = geocodingService;
	}
	
	@GetMapping("/geocode")
	ResponseEntity<Object> geocode(@RequestParam("address") String address) {
		System.out.println("address" + address);
		Object res = geocodingService.geocode(address);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/reversegeocode")
	ResponseEntity<String> reversegeocode(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude) {
		String res = geocodingService.reversegeocode(latitude, longitude);
		return new ResponseEntity<>("Working Fine!", HttpStatus.OK);
	}

}

package com.openweather.service;

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.openweather.exception.JsonParseException;

@Service
public class TemperatureService {

	@Value("${open.weather.url}")
	private String uri;

	@Value("${open.weather.key}")
	private String apiKey;

	private RestTemplate restTemplate;

	public TemperatureService() {
		restTemplate = new RestTemplate();
	}

	public String getCurrentTemperature(String location) {

		ResponseEntity<String> response = null;

		URI url = new UriTemplate(uri).expand(location, apiKey);
		response = restTemplate.getForEntity(url, String.class);

		return this.extractTemprature(response);

	}

	private String extractTemprature(ResponseEntity<String> response) {

		try {
			JSONObject json = new JSONObject(response.getBody());
			return json.getJSONObject("main").get("temp").toString();

		} catch (JSONException e) {
			throw new JsonParseException("Failed to parse Json from response body");
		}

	}

}

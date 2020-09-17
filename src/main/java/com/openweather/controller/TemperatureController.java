package com.openweather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.openweather.service.TemperatureService;

/**
 * Controller
 * @author raharya
 *
 */
@RestController
public class TemperatureController {

	@Autowired
	TemperatureService tempratureService;

	@GetMapping("/current-temperature/{city}")
	public String getTemprature(@PathVariable String city) {
		return tempratureService.getCurrentTemperature(city);

	}

}

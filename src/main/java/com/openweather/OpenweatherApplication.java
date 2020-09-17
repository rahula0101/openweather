package com.openweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Main class for Open Weather Temperature Service
 * @author raharya
 *
 */
@SpringBootApplication
public class OpenweatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenweatherApplication.class, args);
	}
}

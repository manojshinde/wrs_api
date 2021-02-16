package com.codingassignment.wrs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codingassignment.wrs.modelresponse.WeatherResponse;
import com.codingassignment.wrs.service.WeatherService;
import com.google.gson.Gson;

@RestController
public class WeatherRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherRestController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/api/assignment/getWeatherReport/{zip_code}")
	public WeatherResponse retrieveWeatherReport(@PathVariable("zip_code") int zip_code) {
		logger.info("retrieveWeatherReport execution started ..");
		logger.debug("getWeatherReport request param::"+zip_code);
		WeatherResponse response = null;
		try {
			response = weatherService.retriveWeather(zip_code);
		} catch (Exception e) {
			logger.error("Error occured in getWeatherReport method ::"+e.getMessage(),e);
		}
		logger.debug("getWeatherReport Response:: "+new Gson().toJson(response));
		logger.info("retrieveWeatherReport execution complted ..");
		return response;

	}

}

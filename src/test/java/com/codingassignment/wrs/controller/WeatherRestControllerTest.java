package com.codingassignment.wrs.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.codingassignment.wrs.modelresponse.Data;
import com.codingassignment.wrs.modelresponse.WeatherResponse;
import com.codingassignment.wrs.service.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WeatherRestController.class)
@WithMockUser
public class WeatherRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WeatherService weatherService;
	
	WeatherResponse weatherResponse = new WeatherResponse("2021-02-16T08:00:00.000Z", "SUCCESS", 200, "success", 
			new Data(30018, "Jersey", "16-Feb-2021", "08.00 AM", -3.08, "Celcies"));
	

	String WeatherResponseJson = "{\"timestamp\":\"2021-02-16T08:00:00.000Z\",\"info\":\"SUCCESS\",\"status\":200,\"message\":\"success\",\"data\":{\"zipCode\":30018,\"cityName\":\"Jersey\",\"date\":\"16-Feb-2021\",\"coolestHour\":\"08.00 AM\",\"temperature\":-3.08,\"unit\":\"Celcies\"}}";


	@Test
	public void retrieveWeatherReport() throws Exception {

		Mockito.when(weatherService.retriveWeather(Mockito.anyInt())).thenReturn(weatherResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/assignment/getWeatherReport/"+30018).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"timestamp\":\"2021-02-16T08:00:00.000Z\",\"info\":\"SUCCESS\",\"status\":200,\"message\":\"success\",\"data\":{\"zipCode\":30018,\"cityName\":\"Jersey\",\"date\":\"16-Feb-2021\",\"coolestHour\":\"08.00 AM\",\"temperature\":-3.08,\"unit\":\"Celcies\"}}";


		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}

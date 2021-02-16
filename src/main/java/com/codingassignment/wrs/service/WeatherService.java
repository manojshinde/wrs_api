package com.codingassignment.wrs.service;

import static com.codingassignment.wrs.utils.WrsConstants.TIME_STAMP_DF;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingassignment.wrs.modelresponse.LatLongResponse;
import com.codingassignment.wrs.modelresponse.WeatherResponse;
import com.codingassignment.wrs.utils.HttpUtil;
import com.google.gson.Gson;

@Service
public class WeatherService {
	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	@Autowired
	private HttpUtil httpUtil;
	

	public WeatherResponse retriveWeather(int zip_code) {
		logger.info("retriveWeather execution started ..");
		LatLongResponse latLongResponse = null;
		WeatherResponse response = null;
		try {
			if (zip_code>0) {
				latLongResponse = httpUtil.getLatLong(zip_code);
				if (latLongResponse != null && latLongResponse.cod == 200) {
					response = httpUtil.oneCall(latLongResponse);

				} else {
					response = new WeatherResponse(HttpUtil.getDate(null, TIME_STAMP_DF),"Fail", latLongResponse.getCod(), latLongResponse.getMessage());
				}

			} else {
				response = new WeatherResponse(HttpUtil.getDate(null, TIME_STAMP_DF),"Fail", 400, "Please Enter valid Zip_code");
			}

		} catch (Exception e) {
			logger.error("Error occured in retriveWeather method ::"+e.getMessage(),e);
		}
		logger.debug("getWeatherReport Response:: "+new Gson().toJson(response));
		logger.info("retriveWeather execution complted ..");
		
		return response;
		
	}
}

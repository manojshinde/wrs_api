package com.codingassignment.wrs.utils;

import static com.codingassignment.wrs.utils.WrsConstants.API_KEY;
import static com.codingassignment.wrs.utils.WrsConstants.DATE_DF;
import static com.codingassignment.wrs.utils.WrsConstants.ONECALL_API_SERVICE_URI;
import static com.codingassignment.wrs.utils.WrsConstants.OPENWEATHERMAP_SERVICE_URI;
import static com.codingassignment.wrs.utils.WrsConstants.TIME_DF;
import static com.codingassignment.wrs.utils.WrsConstants.TIME_STAMP_DF;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.codingassignment.wrs.modelresponse.Data;
import com.codingassignment.wrs.modelresponse.Hourly;
import com.codingassignment.wrs.modelresponse.LatLongResponse;
import com.codingassignment.wrs.modelresponse.OneCallResponse;
import com.codingassignment.wrs.modelresponse.WeatherResponse;
import com.google.gson.Gson;

@Component
public class HttpUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	@Autowired
	private RestTemplate restTemplate;

	public LatLongResponse getLatLong(int zip_code) {
		logger.info("getLatLong method execution statred..");
		LatLongResponse apiResponse = new LatLongResponse();
		try {
			String uriString = OPENWEATHERMAP_SERVICE_URI + "zip=" + zip_code + ",US&appid=" + API_KEY;
			logger.debug("PoenWeatherMap API Request", uriString);
			apiResponse = restTemplate.getForObject(uriString, LatLongResponse.class);
			logger.debug("PoenWeatherMap API original Response::"+ new Gson().toJson(apiResponse));

			apiResponse.setZip_code(zip_code);

		} catch (Exception e) {
			logger.error("Error Occured In getLatLong method::"+ e.getMessage(),e);
			String message = e.getMessage();
			if (message.contains("4")) {
				apiResponse.setCod(404);
				apiResponse.setMessage("city not found");
				apiResponse.setZip_code(zip_code);
			}
			if (message.contains("5")) {
				apiResponse.setCod(500);
				apiResponse.setMessage("Internal Server Error, Please try later");
				apiResponse.setZip_code(zip_code);
			}

			e.printStackTrace();
		}
		logger.debug("PoenWeatherMap API Response::"+ new Gson().toJson(apiResponse));
		logger.info("getLatLong method execution copleted..");
		return apiResponse;
	}

	public WeatherResponse oneCall(LatLongResponse latLon) {
		logger.info("oneCall method execution statred..");
		OneCallResponse callResponse = null;
		WeatherResponse response = null;
		try {
			logger.info("Calling Onecall aip service to get weather Deatils");
			String uriString = ONECALL_API_SERVICE_URI + "lat=" + latLon.getCoord().getLat() + "&lon="
					+ latLon.getCoord().getLon() + "&exclude=minutely,daily,alerts&appid=" + API_KEY + "&units=metric";
			logger.debug("ONECALL_API_SERVICE_URL::"+ uriString);

			callResponse = restTemplate.getForObject(uriString, OneCallResponse.class);
			logger.debug("ONECALL API ORG RESPONSE::"+ new Gson().toJson(callResponse));
			logger.info("Onecall aip service completed successfully");
			response = buildWeatherResponse(callResponse, latLon);

		} catch (Exception e) {
			logger.error("Exception In oneCall()::"+e.getMessage(),e);
			response = new WeatherResponse(getDate(null, TIME_STAMP_DF), "ERROR", 500, e.getMessage());
		}
		logger.debug("ONECALL API FINAL RESPONSE::"+new Gson().toJson(response));
		logger.info("oneCall method execution copleted..");
		return response;
	}

	public static WeatherResponse buildWeatherResponse(OneCallResponse callResponse, LatLongResponse latLongResponse) {

		logger.info("buildWeatherResponse method execution statred..");
		
		WeatherResponse response = null;

		try {
			logger.debug("Before sort");
			
			callResponse.getHourly().stream().forEach(e -> logger.debug(new Gson().toJson(e)));

			List<Hourly> tempList = callResponse.getHourly().stream().limit(24)
					.sorted(Comparator.comparingDouble(Hourly::getTemp)).collect(Collectors.toList());
			logger.debug("after sort");
			tempList.stream().forEach(e -> logger.debug(new Gson().toJson(e)));

			Hourly hourly = tempList.get(0);
			response = new WeatherResponse(getDate(hourly.getDt(), TIME_STAMP_DF), "SUCCESS", 200, "success",
					new Data(latLongResponse.getZip_code(), latLongResponse.getName(), getDate(hourly.getDt(), DATE_DF),
							getDate(hourly.getDt(), TIME_DF), hourly.getTemp(), "Celcies"));
		} catch (Exception e2) {
			logger.error("Exception in buildWeatherResponse()::"+e2.getMessage(),e2);
		}
		logger.info("buildWeatherResponse method execution copleted..");
		return response;

	}

	public static String getDate(Long unix_seconds, String df) {
		Date date = null;
		if (unix_seconds != null) {
			date = new Date(unix_seconds * 1000L);
		} else {
			date = new Date();
		}
		SimpleDateFormat jdf = new SimpleDateFormat(df);
		if (unix_seconds != null)
			jdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		String java_date = jdf.format(date);

		return java_date;

	}

}

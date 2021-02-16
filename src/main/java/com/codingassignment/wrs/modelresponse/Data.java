package com.codingassignment.wrs.modelresponse;

import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = -6375588712142530596L;

	private Integer zipCode;
	private String cityName;
	private String date;
	private String coolestHour;
	private Double temperature;
	private String unit;

	public Data() {
		super();
	}

	public Data(Integer zipCode, String cityName, String date, String coolestHour, Double temperature, String unit) {
		super();
		this.zipCode = zipCode;
		this.cityName = cityName;
		this.date = date;
		this.coolestHour = coolestHour;
		this.temperature = temperature;
		this.unit = unit;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCoolestHour() {
		return coolestHour;
	}

	public void setCoolestHour(String coolestHour) {
		this.coolestHour = coolestHour;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Data [zipCode=" + zipCode + ", cityName=" + cityName + ", date=" + date + ", coolestHour=" + coolestHour
				+ ", temperature=" + temperature + ", unit=" + unit + "]";
	}

}

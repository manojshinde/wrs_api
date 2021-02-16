
package com.codingassignment.wrs.modelresponse;

import java.io.Serializable;
import java.util.List;

public class OneCallResponse implements Serializable {

	private Double lat;
	private Double lon;
	private String timezone;
	private Integer timezoneOffset;
	private Current current;
	private List<Hourly> hourly = null;
	private final static long serialVersionUID = 1994883666659817106L;

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Integer getTimezoneOffset() {
		return timezoneOffset;
	}

	public void setTimezoneOffset(Integer timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
	}

	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	public List<Hourly> getHourly() {
		return hourly;
	}

	public void setHourly(List<Hourly> hourly) {
		this.hourly = hourly;
	}

	@Override
	public String toString() {
		return "OneCallResponse [lat=" + lat + ", lon=" + lon + ", timezone=" + timezone + ", timezoneOffset="
				+ timezoneOffset + ", current=" + current + ", hourly=" + hourly + "]";
	}

}

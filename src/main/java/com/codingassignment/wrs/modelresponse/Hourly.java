
package com.codingassignment.wrs.modelresponse;

import java.io.Serializable;

public class Hourly implements Serializable {

	private Long dt;
	private Double temp;
	/*
	 * private Double feelsLike; private Integer pressure; private Integer humidity;
	 * private Double dewPoint; private Integer uvi; private Integer clouds; private
	 * Integer visibility; private Double windSpeed; private Integer windDeg;
	 * private Integer pop; private Rain rain;
	 */
	private final static long serialVersionUID = 3339897588869997661L;

 

	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Hourly [dt=" + dt + ", temp=" + temp + "]";
	}

	/*
	 * public Double getFeelsLike() { return feelsLike; }
	 * 
	 * public void setFeelsLike(Double feelsLike) { this.feelsLike = feelsLike; }
	 * 
	 * public Integer getPressure() { return pressure; }
	 * 
	 * public void setPressure(Integer pressure) { this.pressure = pressure; }
	 * 
	 * public Integer getHumidity() { return humidity; }
	 * 
	 * public void setHumidity(Integer humidity) { this.humidity = humidity; }
	 * 
	 * public Double getDewPoint() { return dewPoint; }
	 * 
	 * public void setDewPoint(Double dewPoint) { this.dewPoint = dewPoint; }
	 * 
	 * public Integer getUvi() { return uvi; }
	 * 
	 * public void setUvi(Integer uvi) { this.uvi = uvi; }
	 * 
	 * public Integer getClouds() { return clouds; }
	 * 
	 * public void setClouds(Integer clouds) { this.clouds = clouds; }
	 * 
	 * public Integer getVisibility() { return visibility; }
	 * 
	 * public void setVisibility(Integer visibility) { this.visibility = visibility;
	 * }
	 * 
	 * public Double getWindSpeed() { return windSpeed; }
	 * 
	 * public void setWindSpeed(Double windSpeed) { this.windSpeed = windSpeed; }
	 * 
	 * public Integer getWindDeg() { return windDeg; }
	 * 
	 * public void setWindDeg(Integer windDeg) { this.windDeg = windDeg; }
	 * 
	 * public Integer getPop() { return pop; }
	 * 
	 * public void setPop(Integer pop) { this.pop = pop; }
	 * 
	 * public Rain getRain() { return rain; }
	 * 
	 * public void setRain(Rain rain) { this.rain = rain; }
	 * 
	 * @Override public String toString() { return "Hourly [dt=" + dt + ", temp=" +
	 * temp + ", feelsLike=" + feelsLike + ", pressure=" + pressure + ", humidity="
	 * + humidity + ", dewPoint=" + dewPoint + ", uvi=" + uvi + ", clouds=" + clouds
	 * + ", visibility=" + visibility + ", windSpeed=" + windSpeed + ", windDeg=" +
	 * windDeg + ", pop=" + pop + ", rain=" + rain + "]"; }
	 */

	
}


package com.codingassignment.wrs.modelresponse;

import java.io.Serializable;

public class WeatherResponse implements Serializable {
	private final static long serialVersionUID = -8692109293267732509L;

	private String timestamp;
	private String info;
	private Integer status;
	private String message;
	private Data data;
	public WeatherResponse() {
		super();
	}
	
	public WeatherResponse(String timestamp, String info, Integer status, String message) {
		super();
		this.timestamp = timestamp;
		this.info = info;
		this.status = status;
		this.message = message;
	}
	
	
	public WeatherResponse(String timestamp, String info, Integer status, String message, Data data) {
		super();
		this.timestamp = timestamp;
		this.info = info;
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "WeatherResponse [timestamp=" + timestamp + ", info=" + info + ", status=" + status + ", message="
				+ message + ", data=" + data + "]";
	}

	

}

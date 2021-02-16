package com.codingassignment.wrs.modelresponse;

public class CommonResponse {
	private String timestamp;
	private String info;
	private Integer status;
	private String message;

	
	public CommonResponse() {
		super();
	}

	

	public CommonResponse(String timestamp, String info, Integer status, String message) {
		super();
		this.timestamp = timestamp;
		this.info = info;
		this.status = status;
		this.message = message;
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


	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "CommonResponse [info=" + info + ", status=" + status + ", message=" + message + ", date=" + timestamp + "]";
	}

}

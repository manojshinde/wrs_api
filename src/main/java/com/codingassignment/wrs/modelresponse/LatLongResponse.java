package com.codingassignment.wrs.modelresponse;

public class LatLongResponse {

	public int cod;

	private Coord coord;

	private int zip_code;

	private String name;

	private String message;

	public LatLongResponse() {
		super();
	}

	public LatLongResponse(int cod, Coord coord, int zip_code, String name, String message) {
		super();
		this.cod = cod;
		this.coord = coord;
		this.zip_code = zip_code;
		this.name = name;
		this.message = message;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LatLongResponse [cod=" + cod + ", coord=" + coord + ", zip_code=" + zip_code + ", name=" + name
				+ ", message=" + message + "]";
	}

}

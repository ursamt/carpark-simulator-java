package com.ursamt.carpark.simulator;

public class Car {

	private String brand;
	private String regNum;

	public Car(String brand, String regNum) {
		this.brand = brand;
		this.regNum = regNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

}

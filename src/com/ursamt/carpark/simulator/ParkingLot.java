package com.ursamt.carpark.simulator;

import java.util.Date;

public class ParkingLot implements Comparable<ParkingLot>{

	private String lotNum;
	private boolean occupied = false;
	private Car car;
	private Date parkingStart;
	private Date parkingEnd;

	public ParkingLot(String lotNum) {
		super();
		this.lotNum = lotNum;
	}

	public String getLotNum() {
		return lotNum;
	}

	public void setLotNum(String lotNum) {
		this.lotNum = lotNum;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Date getParkingStart() {
		return parkingStart;
	}

	public void setParkingStart(Date parkingStart) {
		this.parkingStart = parkingStart;
	}

	public Date getParkingEnd() {
		return parkingEnd;
	}

	public void setParkingEnd(Date parkingEnd) {
		this.parkingEnd = parkingEnd;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String toString() {
		StringBuilder parkingLotInfoBuilder = new StringBuilder();
		parkingLotInfoBuilder.append("[ Parking Lot : ").append(this.getLotNum()).append(", Is Occupied: ")
				.append(this.isOccupied());
		if (this.getCar() != null) {
			parkingLotInfoBuilder.append(". Currently occupied by : [").append(this.getCar().getBrand()).append(",")
					.append(this.getCar().getRegNum()).append("]");
		}
		parkingLotInfoBuilder.append("]");

		return parkingLotInfoBuilder.toString();
	}

	@Override
	public int compareTo(ParkingLot o) {
		return 0;
	}
}

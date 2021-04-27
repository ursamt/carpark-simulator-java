package com.ursamt.carpark.simulator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

public class CarPark {

	private String name;
	private int noOfLots;
	private boolean full = false;
	private double rate;

	private Queue<ParkingLot> parkingLots;
	private List<ParkingLot> takenParkingLots;

	public CarPark(String name, int noOfLots, double rate, Queue<ParkingLot> parkingLots) {
		super();
		this.name = name;
		this.noOfLots = noOfLots;
		this.full = false;
		this.rate = rate;
		this.parkingLots = parkingLots;
		this.takenParkingLots = new ArrayList<>(parkingLots.size());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfLots() {
		return noOfLots;
	}

	public void setNoOfLots(int noOfLots) {
		this.noOfLots = noOfLots;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void freeUp(ParkingLot parkingLot) {

		Car parkedCar = parkingLot.getCar();
		System.out.println();
		System.out.println("About to unpark [" + parkedCar.getBrand() + "," + parkedCar.getRegNum() + "] from lot : "
				+ parkingLot.getLotNum());

		parkingLot.setParkingEnd(new Date());

		calculateAndPrintParkingCharges(parkingLot);

		exitCarParkAndFreeUpParkingLot(parkingLot, parkedCar);
	}

	private void exitCarParkAndFreeUpParkingLot(ParkingLot parkingLot, Car parkedCar) {

		parkingLot.setCar(null);
		parkingLot.setOccupied(false);
		parkingLot.setParkingStart(null);
		parkingLot.setParkingEnd(null);
		takenParkingLots.remove(parkingLot);
		parkingLots.add(parkingLot);

		System.out.println("Car " + parkedCar.getBrand() + " has been successfully unparked from lot num : "
				+ parkingLot.getLotNum());
		System.out.println();
	}

	private void calculateAndPrintParkingCharges(ParkingLot parkingLot) {

		long totalTimeParkedInMin = (((parkingLot.getParkingEnd().getTime() - parkingLot.getParkingStart().getTime())
				/ 1000) / 60);
		double chargesPerMin = this.getRate() / 60;
		double totalCharges = totalTimeParkedInMin * chargesPerMin;

		System.out.println("Parking Started at: " + parkingLot.getParkingStart());
		System.out.println("Parking Ended at: " + parkingLot.getParkingStart());
		System.out.println("Total parked time (mins): " + totalTimeParkedInMin);
		System.out.println("Parking charges: " + totalCharges);
	}

	public ParkingLot park(Car car) {

		ParkingLot parkingLot = null;

		if (!parkingLots.isEmpty()) {
			parkingLot = parkingLots.remove();
			parkingLot.setCar(car);
			parkingLot.setParkingStart(new Date());
			parkingLot.setOccupied(true);
			takenParkingLots.add(parkingLot);

		} else {
			System.out.println("There are no free lots available. Please wait...");
		}

		return parkingLot;

	}

	public void viewParkedCars() {

		if (takenParkingLots.isEmpty()) {
			System.out.println("Currently no parked cars");
		} else {
			System.out.println("**********************************************");
			System.out.println("Currently parked cars");
			System.out.println("**********************************************");
			takenParkingLots.forEach((parkingLot) -> {
				System.out.println();
				System.out.println("Parking Lot: " + parkingLot.getLotNum());
				System.out.println("Car Brand: " + parkingLot.getCar().getBrand());
				System.out.println("Car Reg Num: " + parkingLot.getCar().getRegNum());
				System.out.println("Parked since : " + parkingLot.getParkingStart());
			});
			System.out.println();
			System.out.println("**********************************************");
		}

	}

	public String toString() {

		StringBuilder carParkInfoBuilder = new StringBuilder();
		carParkInfoBuilder.append("[ Car Park name : ").append(this.getName()).append(", Available Lots : ")
				.append(this.getNoOfLots()).append(" ]");

		return carParkInfoBuilder.toString();
	}

	public List<ParkingLot> getTakenParkingLots() {
		return this.takenParkingLots;
	}
}

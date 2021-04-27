package com.ursamt.carpark.simulator;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class CarParkApp {

	public static final int NO_OF_LOTS = 3;
	public static final int CARS_WAITING_TO_BE_PARKED = 5;
	public static final String CAR_PARK_NAME = "My Car Park";
	public static final double HOURLY_PARKING_RATE = 1.20;

	public static void main(String args[]) {

		CarParkApp carParkApp = new CarParkApp();
		carParkApp.start();

	}

	private void start() {

		CarPark carPark = createCarPark(NO_OF_LOTS);

		Queue<Car> carsQueue = createCars();
		System.out.println("Total no. of cars in the queue : " + carsQueue.size());

		showCarParkOptionsAndHandle(carPark, carsQueue);
	}

	private void showCarParkOptionsAndHandle(CarPark carPark, Queue<Car> carsQueue) {

		int choice = -1;

		Scanner scanner = new Scanner(System.in);

		do {
			printCarParkOptions();
			choice = Integer.parseInt(scanner.next());
			System.out.println("You have entered : " + choice);

			handleOption(carPark, carsQueue, choice);

		} while (choice != 0);

		scanner.close();
	}

	private void handleOption(CarPark carPark, Queue<Car> carsQueue, int choice) {

		switch (choice) {
		case 1:
			doPark(carPark, carsQueue);
			break;
		case 2:
			carPark.viewParkedCars();
			break;
		case 3:
			if (!carPark.getTakenParkingLots().isEmpty()) {
				doUnPark(carPark);

			} else {
				System.out.println("Car park is currently empty");
			}
			break;
		case 0:
				System.out.println("Bye");
			break;
		default:
			System.out.println("Invalid choice");
			break;

		}
	}

	private void doUnPark(CarPark carPark) {

		System.out.println("Please enter the parking lot number");
		@SuppressWarnings("resource")
		Scanner parkingLotInput = new Scanner(System.in);
		String parkingLotNum = parkingLotInput.nextLine();
		ParkingLot parkingLot = carPark.getTakenParkingLots().stream()
				.filter(takenParkingLot -> takenParkingLot.getLotNum().equalsIgnoreCase(parkingLotNum)).findAny()
				.orElse(null);
		if (parkingLot != null) {
			System.out.println(parkingLot.toString());
			carPark.freeUp(parkingLot);
		} else {
			System.out.println("Can't find a car in the parking lot with number : " + parkingLotNum);
		}
	}

	private void doPark(CarPark carPark, Queue<Car> carsQueue) {

		if (!carsQueue.isEmpty()) {
			Car car = carsQueue.peek();
			System.out.println("Attempting to park " + car.getBrand() + ", with reg num:" + car.getRegNum());
			ParkingLot parkingLot = carPark.park(car);
			if (parkingLot != null) {
				System.out.println("Car has been parked at " + parkingLot.getLotNum());
				carsQueue.remove(car);
			}

		} else {
			System.out.println("There are no cars waiting to be parked");
		}
	}

	private void printCarParkOptions() {
		System.out.println();
		System.out.println("Please enter your choice");
		System.out.println("1. Park the next car waiting in the queue");
		System.out.println("2. View parked cars");
		System.out.println("3. Unpark the car");
		System.out.println("0. Exit");
		System.out.print(">");
	}

	private CarPark createCarPark(int noOfLots) {

		CarPark carPark = new CarPark(CAR_PARK_NAME, NO_OF_LOTS, HOURLY_PARKING_RATE, createParkingLots(noOfLots));
		System.out.println("|******************************************************************");
		System.out.println(carPark.toString());
		System.out.println("|******************************************************************");
		return carPark;
	}

	private Queue<Car> createCars() {

		Queue<Car> carsQueue = new LinkedBlockingQueue<>(CARS_WAITING_TO_BE_PARKED);
		carsQueue.add(new Car("Toyota", "SG123"));
		carsQueue.add(new Car("Audi", "SG124"));
		carsQueue.add(new Car("Merz", "SG125"));
		carsQueue.add(new Car("Ford", "SG126"));
		carsQueue.add(new Car("Nissan", "SG127"));

		return carsQueue;
	}

	private Queue<ParkingLot> createParkingLots(int lots) {

		Queue<ParkingLot> parkingLots = new PriorityQueue<>(lots);
		parkingLots.add(new ParkingLot("P1"));
		parkingLots.add(new ParkingLot("P2"));
		parkingLots.add(new ParkingLot("P3"));

		return parkingLots;
	}
}

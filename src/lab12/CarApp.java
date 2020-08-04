package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarApp {
	public static Scanner scnr = new Scanner(System.in);
	public static List<Car> cars = new ArrayList<>();

	// public static Car car=new Car();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the GC Car terminal admin page!\n");
		addCar();
		System.out.println("Current Inventory: ");
		listCars();
	}

	public static void addCar() {
		int count;
		count = Validator.getInt(scnr, "How many cars are you entering: ");
		int year;
		double price;
		for (int i = 0; i < count; i++) {
			Car car = new Car();
			System.out.println("Enter Car #" + (i + 1) + " Make: ");
			car.setMake(scnr.nextLine());
			System.out.println("Enter Car #" + (i + 1) + " Model: ");
			car.setModel(scnr.nextLine());
			year = Validator.getValidateYear(scnr, "Enter Car #" + (i + 1) + " Year: ");
			car.setYear(year);
			price = Validator.getDouble(scnr, "Enter Car #" + (i + 1) + " Price: ");
			car.setPrice(price);
			cars.add(car);
		}
	}

	public static void listCars() {
		System.out.printf("%-15s%-15s%-15s%-15s\n","Make","Model","Year","Price");
		System.out.printf("%-15s%-15s%-15s%-15s\n","====","=====","====","=====");
		for (Car car : cars) {
			// for(int i=0;i<cars.size();i++) {
			// System.out.println("Car "+(i+1)+": "+cars.get(i));
			
			System.out.printf("%-15s%-15s%-15d$%-15.2f\n", car.getMake(), car.getModel(), car.getYear(),
					car.getPrice());
		}
	}
}

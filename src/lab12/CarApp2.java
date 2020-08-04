package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarApp2 {
	public static Scanner scnr = new Scanner(System.in);
	public static List<Car> cars = new ArrayList<>();
	static {
		cars.add(new Car("Nissan", "Rogue", 2019, 24000.00));
		cars.add(new Car("Ford", "Sedan", 2015, 45000.00));
		cars.add(new Car("Toyota", "Camery", 2009, 20000.00));
		cars.add(new UsedCar("Suburu", "Crossover", 1999, 6000.00, 13000.00));
		cars.add(new UsedCar("Honda", "Civic", 2009, 5000.00, 18000.00));
		cars.add(new UsedCar("Mitsubishi", "Lancer", 2000, 6000.00, 3000.00));
	}

	public static void main(String[] args) {
		int userInput;
		boolean yesNo;
		boolean again = true;
		System.out.println("List of available cars");
		do {
			listCars();
			userInput = Validator.getInt(scnr, "Which car would you like?");
			if (userInput <= cars.size()) {
				showCarById(userInput);
				yesNo = Validator.getYesNo(scnr, "Would you like to buy this car?(y/n)");
				if (yesNo == true) {
					System.out.println("Excellent! Our finance department will be in touch shortly.");
					System.out.println();
					buyCar(userInput);
				} else {
					System.out.println("It's okay! You can check other cars");
				}
				
			} else {
				System.out.println("Have a great day!");
				again = false;
			}
		} while (again);
	}

	public static void listCars() {

		for (int i = 0; i < cars.size(); i++) {
			// System.out.println("Car "+(i+1)+": "+cars.get(i));
			if (cars.get(i) instanceof UsedCar) {
				System.out.printf("%-5d%-15s%-15s%-15d$%-10.2f(used)%.2f\n", (i + 1), ((UsedCar) cars.get(i)).getMake(),
						((UsedCar) cars.get(i)).getModel(), ((UsedCar) cars.get(i)).getYear(),
						((UsedCar) cars.get(i)).getPrice(), ((UsedCar) cars.get(i)).getMileage());

			} else {
				System.out.printf("%-5d%-15s%-15s%-15d$%-15.2f\n", (i + 1), cars.get(i).getMake(),
						cars.get(i).getModel(), cars.get(i).getYear(), cars.get(i).getPrice());

			}
		}
		System.out.printf("%-5d%s\n", cars.size() + 1, "Quit");
	}

	public static void showCarById(int id) {
		if ((cars.get(id - 1) instanceof UsedCar)) {
			System.out.printf("%-5d%-15s%-15s%-15d$%-10.2f(used)%.2f\n", (id), ((UsedCar) cars.get(id - 1)).getMake(),
					((UsedCar) cars.get(id - 1)).getModel(), ((UsedCar) cars.get(id - 1)).getYear(),
					((UsedCar) cars.get(id - 1)).getPrice(), ((UsedCar) cars.get(id - 1)).getMileage());
		} else {
			System.out.printf("%-5d%-15s%-15s%-15d$%-15.2f\n", (id), cars.get(id - 1).getMake(),
					cars.get(id - 1).getModel(), cars.get(id - 1).getYear(), cars.get(id - 1).getPrice());
		}
		// System.out.println(cars.get(id-1));
	}

	public static void buyCar(int id) {
		cars.remove(id - 1);
	}
}

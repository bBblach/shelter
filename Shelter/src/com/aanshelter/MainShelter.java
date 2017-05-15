package com.aanshelter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainShelter {
	private static int maxShelterSize = 4;
	static ArrayList<Animal> animalList = new ArrayList<>(maxShelterSize);
	static Scanner keyboard_input = new Scanner(System.in);
	public static IdGenerator idGenertor = new IdGenerator();
	static MainShelter main = new MainShelter();
	public static ArrayList<Integer> idList = idGenertor.generateListOfAvailIds();

	public static void showMenu() {

		StringBuilder menu = new StringBuilder("HELLO");
		menu.append("\nWelcome to our shelter \"Chicken Wing\", to:  ");
		menu.append("\nCheck list of animals enter:      status");
		menu.append("\nAdd new animal to shleter enter:  add");
		menu.append("\nremove animal form shelter enter: remove").append("\nquit program enter:               quit")
				.append("\ngo back to menu enter:            menu");

		System.out.println(menu);
	}

	public static void main(String[] args) throws IOException {
		int noOfAnimals = 0;
		showMenu();

		String wybor = null;
		do {
			System.out.print(": ");
			wybor = keyboard_input.next();
			switch (wybor) {

			// ********************STATUS
			case "status":
				noOfAnimals = main.checkStatus();
				if (noOfAnimals == 1) {
					System.out.println("There is " + noOfAnimals + " animal");
				} else {
					System.out.println("There are: " + noOfAnimals + " animals");
				}

				if (noOfAnimals != 0) {
					for (Animal singleAnimal : animalList) {
						System.out.println(animalList.indexOf(singleAnimal) + " " + " id: " + singleAnimal.getId()
								+ " name: " + singleAnimal.getName() + " age: " + singleAnimal.getAge());
					}
					if (noOfAnimals == maxShelterSize) {
						System.out.println("The sherler is full, you can't add any more animals");
					}

				}
				break;
			// ******************* DODAWNIE
			case "add": {
				if (animalList.size() < maxShelterSize) {
					addAnimal();
				} else {
					System.out.println("you can't add new animal, the shelter is full");
				}

			}
				break;

			// ***************** REMOVE
			case "remove": {
				if (noOfAnimals == 0) {
					System.out.println("There are not animals in shelter");
					break;
				}
				System.out.print("Enter id of an animal which you wan to remove: ");
				int id = keyboard_input.nextInt();
				int indexOfRemoved = findAnimalIndex(id);
				animalList.remove(indexOfRemoved);
				idGenertor.retriveId(id, idList);
			}
				break;
			case "menu":
				showMenu();
			}
		} while (!wybor.equals("quit"));

		System.out.println("bye !");
	}

	public int checkStatus() {
		return animalList.size();
	}

	static void addAnimal() {
		System.out.println("To add new animal to shelter enter id, name and age of new animal");

		int id = idGenertor.drawRandomId(idList);
		System.out.print("name: ");
		String name = keyboard_input.next();
		System.out.print("age: ");
		int age = keyboard_input.nextInt();
		System.out.println("You added new animal to the shelter ");
		Animal newAnimal = new Animal(id, name, age);
		animalList.add(newAnimal);
		idGenertor.removeId(id, idList);
	}

	public static int findAnimalIndex(int id) {

		for (Animal animal : animalList) {
			if (animal.getId() == id) {
				return animalList.indexOf(animal);
			}
		}
		return -1;
	}
}

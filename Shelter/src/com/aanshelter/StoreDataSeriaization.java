package com.aanshelter;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StoreDataSeriaization {

	public static void writeToFile(int amountOfanimals) {
		
		try (FileOutputStream fos = new FileOutputStream("animals.bin")) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < amountOfanimals; i++) {
				oos.writeObject(MainShelter.animalList.get(i));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("saving data...");
	}

	public static ArrayList<Animal> readFromFile() {

		System.out.println("reading from file ... ");
		ArrayList<Animal> savedList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream("animals.bin")) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			while (true){
				Object o = ois.readObject();
				savedList.add((Animal) o);
			}
				
		} catch (EOFException e){
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("objects red");
		return savedList;

	}

}

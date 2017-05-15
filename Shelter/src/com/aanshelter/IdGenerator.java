package com.aanshelter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class IdGenerator {
	
	public ArrayList<Integer >generateListOfAvailIds(){
		ArrayList<Integer> listOfAvailIds = new ArrayList<>(20);
		Integer[] tableOfAvailIds = new Integer[20];
		tableOfAvailIds[0] = 1;
		for (int i = 0; i < tableOfAvailIds.length; i++) {
			tableOfAvailIds[i] = i + 1;
		}														// tworzenie i wypelnianie tabeli
		listOfAvailIds.addAll(Arrays.asList(tableOfAvailIds));	// zamiana tabeli na liste 
		return listOfAvailIds;
	}
	
	public  void removeId(int sampleId1, ArrayList<Integer> allIdList) {

		for (int i = 0; i < allIdList.size(); i++) {
			if (sampleId1 == i) {
				int indexOfRepetition = allIdList.indexOf(sampleId1);
				allIdList.remove(indexOfRepetition);
			}
		}
	}
	public  void retriveId(int sampleId, ArrayList<Integer>idList){
		idList.add(sampleId,sampleId);
		
	}
	
	public int drawRandomId(ArrayList<Integer> idList){
		
		Random generator = new Random();
		int randomIndex = generator.nextInt(idList.size());
		System.out.println("random index is: "+randomIndex );
		return idList.get(randomIndex);
		
	}
}

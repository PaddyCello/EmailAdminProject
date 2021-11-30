package com.pjohnson_wtc.email_admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Admin {
	
	private String[] departments = {"sales", "development", "accounting"};
	private List<NewHire> allNewHires = new ArrayList<NewHire>();
	
	public String[] getDepartments() {
		return departments;
	}
	
	public List<NewHire> getAllNewHires() {
		return allNewHires;
	}
	
	public NewHire findNewHireById(String email) {
		//TODO
		return null;
	}
	
	//Method for creating new NewHire objects from Admin
	public String createNewHire(String firstName, String lastName, String department) {
		
		//Validation check - no missing name
		if (firstName == null || lastName == null) {
			System.out.println("Invalid format: missing fields");
			return "Invalid format";
			
		//Validation check - department given as argument exists
		} else if (department != null && 
				Arrays.asList(departments).stream()
				.filter(x -> x.equals(department.toLowerCase()))
				.collect(Collectors.toList()).size() == 0) {
			System.out.println("Invalid format: department not listed");
			return "Department not listed";
		
		//If checks are successful:
		} else {
			
			//Create NewHire object
			NewHire newHire = new NewHire(firstName, lastName, department);
			
			//Add NewHire to Admin.allNewHires
			allNewHires.add(newHire);
			
			//Return email address - could also use for search purposes
			return newHire.getEmail();
		}
	}
	
}

package com.pjohnson_wtc.email_admin;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	
	private static String[] departments = {"sales", "development", "accounting"};
	private static List<NewHire> allNewHires = new ArrayList<NewHire>();
	
	public String[] getDepartments() {
		return departments;
	}
	
	public List<NewHire> getAllNewHires() {
		return allNewHires;
	}
	//TODO
	public NewHire findNewHireById(String email) {
		return null;
	}
	
	//Validation check - no missing name
	private boolean checkValidName(String firstName, String lastName) {
		return (firstName == null || lastName == null) ? false : true;
	}
	
	//Validation check - department passed as argument is valid
	private boolean checkValidDepartment(String department) {
		boolean departmentExists = (department == null) ? true : false;
		
		for (String dept : departments) {
			if (dept.equalsIgnoreCase(department)) {
				departmentExists = true;
				break;
			}
		}
		return departmentExists;
	}
	
	//Method for creating new NewHire objects from Admin
	public String createNewHire(String firstName, String lastName, String department) {
		
		if (!checkValidName(firstName, lastName)) return "Invalid format";
		if (!checkValidDepartment(department)) return "Department not listed";
			
			//Create NewHire object
			NewHire newHire = new NewHire(firstName, lastName, department);
			
			//Add NewHire to Admin.allNewHires
			allNewHires.add(newHire);
			
			//Return email address - could also use for search purposes
			return newHire.getEmail();
	}
	
}

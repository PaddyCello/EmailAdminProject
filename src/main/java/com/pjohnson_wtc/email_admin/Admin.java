package com.pjohnson_wtc.email_admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Admin {
	
	//Create logger
	private static Logger logger = Logger.getLogger("com.pjohnson_wtc.email_admin.admin");
	
	//Instance variables for Admin
	private static String[] departments = {"sales", "development", "accounting"};
	private List<NewHire> allNewHires = new ArrayList<NewHire>();
	
	//Method for creating new NewHire objects from Admin
	public String createNewHire(String firstName, String lastName, String department) {
			
		logger.info("Creating new NewHire object");
			
		if (!checkValidName(firstName, lastName)) return "Invalid format";
		if (!checkValidDepartment(department)) return "Department not listed";
		if (!checkUnique(firstName, lastName, department)) return "Email already exists";
				
			//Create NewHire object
			NewHire newHire = new NewHire(firstName, lastName, department);
				
			//Add NewHire to Admin.allNewHires
			allNewHires.add(newHire);
				
			logger.info("NewHire created, with firstName, lastName, department, email and password initialized.");
				
			//Return email address - could also use for search purposes
			return newHire.getEmail();
	}
	
	//Method for finding new hire by email address
	public NewHire findNewHireById(String email) {
			
		//Default result to null
		NewHire foundHire = null;
			
		//Loop through allNewHires, checking equality between email argument and emails for entries
		if (allNewHires.size() > 0) {
			for (NewHire hire : allNewHires) {
				
				if (hire.getEmail().equals(email)) {
					
					//If a match is found, assign the entry to foundHire and break the loop
					foundHire = hire;
					break;
				}
			}
		}
			
		//Log a warning if no result is returned
		if (foundHire == null) logger.log(Level.WARNING, "Email not found.");
			
		//Return result
		return foundHire;
	}
		
	//Validation check - no missing name
	private boolean checkValidName(String firstName, String lastName) {
		boolean nameValid = (firstName == null || lastName == null) ? false : true;
		
		if (!nameValid) logger.log(Level.WARNING, "Incomplete name supplied");
		return nameValid;
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
		
		if (!departmentExists) logger.log(Level.WARNING, "Invalid department");
		
		return departmentExists;
	}
	
	//Validation check - preventing duplicate entries in allNewHires
	private boolean checkUnique(String firstName, String lastName, String department) {
		
		//Initialize result to true
		boolean isUnique = true;
		
		//Loop through allNewHires, checking for equality between arguments given and corresponding fields
		if (allNewHires.size() > 0) {
			
			for (NewHire hire : allNewHires) {
				
				if (hire.getFirstName() == firstName &&
					hire.getLastName() == lastName &&
					hire.getDepartment() == department) {
					
					//If all three match, set isUnique to false and break the loop
					isUnique = false;
					break;
				}
			}
		}
		
		//Log warning if duplicate found and return result
		if (!isUnique) logger.log(Level.WARNING, "Email address already exists for this person.");
		return isUnique;
	}
	
	//Getters
	public String[] getDepartments() {
		return departments;
	}
		
	public List<NewHire> getAllNewHires() {
		return allNewHires;
	}	
		
	public static void main(String[] args) throws IOException {
		
		//Setup for logger and file handler
		FileHandler fileHandler = new FileHandler("logfile.txt");
		fileHandler.setFormatter(new SimpleFormatter());
		logger.setLevel(Level.ALL);
		fileHandler.setLevel(Level.ALL);
		logger.addHandler(fileHandler);
		
		logger.fine("All fine");
	}
}

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
	private static List<NewHire> allNewHires = new ArrayList<NewHire>();
	
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
	
	//Getters
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

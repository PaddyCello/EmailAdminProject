package com.pjohnson_wtc.email_admin;

import java.util.Random;

//Class for new hires
public class NewHire {
	
	//Instance variables - mailboxCapacity is initially given a default value
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	private String alternateEmail;
	private int mailboxCapacity = 2000000;
	private String password;
	
	//Constructor - will be called from within Admin.createNewHire()
	public NewHire(String firstName, String lastName, String department) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.email = generateEmail(firstName, lastName, department);
		this.password = generatePassword();
	}
	
	//Generate email - call from constructor
	private String generateEmail(String firstName, String lastName, String department) {
			
		//Beginning of email always follows same format
		String emailStart = firstName + "." + lastName + "@";
			
		//End will be different depending on whether department is supplied
		String emailEnd = department != null ? department + ".company.com" : "company.com";
			
		//Email must be in lower case
		return (emailStart + emailEnd).toLowerCase();
	}

	//Necessary getters and setters
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getEmail() { 
		return email;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	//Will need getter for testing purposes, can remove after
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		return firstName + " " + lastName + ", " + department + ": " + email;
	}
	
	//-----TODOS-----
	
	//TODO
	public void setAlternateEmail(String alternateEmail) {

	}
	
	//TODO
	public void setMailboxCapacity(int mailboxCapacity) {

	}
	
	//TODO
	public void setPassword(String password) {

	}
	
	//Will be called from the constructor
	//TODO
	private String generatePassword() {
		int passwordLength = (int)Math.floor(Math.random() * 10) + 10;
		char[] passwordLetters = new char[passwordLength];
		String testPassword = "";
		for (char letter : passwordLetters) {
			letter = (char)((int)(Math.random() * 93) + 33);
			testPassword = testPassword + letter;
		}
		return testPassword;
	}
}

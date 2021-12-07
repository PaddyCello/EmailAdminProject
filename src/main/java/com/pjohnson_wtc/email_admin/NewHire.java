package com.pjohnson_wtc.email_admin;

import java.util.ArrayList;
import java.util.List;

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
	
	//Generate random password
	private String generatePassword() {
			
		//Set random length between 10 and 20 characters
		int passwordLength = (int)((Math.random() * 10) + 10);
			
		//Initialize empty string
		String temporaryPassword = "";
			
		//Loop across range from zero to password length, generating random ASCII characters
		for (int i = 0; i < passwordLength; i++) {
				
			char letter = (char)((int)(Math.random() * 93) + 33);
				
			//Concatenate each character to password string
			temporaryPassword = temporaryPassword + letter;
		}
			
		//Return password
		return temporaryPassword;
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
		
		//Format validation
		//In terms of minimum length, @ + . + top level domain = at least 4, plus at least one character each for username and domain
		if (alternateEmail.contains("@") && 
				alternateEmail.contains(".") && 
				alternateEmail.length() > 5) {
			
			this.alternateEmail = alternateEmail;
		}
	}
	
	//TODO
	public void setMailboxCapacity(int mailboxCapacity) {
		if (mailboxCapacity > 0) {
			this.mailboxCapacity = mailboxCapacity;
		}
	}
	
	//TODO
	private String validatePasswordFormat(String password) {
		char[] passwordLetters = password.toCharArray();
		boolean upperCase = false;
		boolean lowerCase = false;
		boolean hasNumber = false;
		boolean hasSpecialChar = false;
		
		for (char letter : passwordLetters) {
			if (Character.isUpperCase(letter)) {
				upperCase = true;
			}
			if (Character.isLowerCase(letter)) {
				lowerCase = true;
			}
			if (Character.isDigit(letter)) {
				hasNumber = true;
			}
			if ((letter > 32 && letter < 48) ||
					(letter > 57 && letter < 65) ||
					(letter > 90 && letter < 97) ||
					(letter > 122 && letter < 127)) {
				hasSpecialChar = true;
			}
		}
		return (upperCase && lowerCase && hasNumber && hasSpecialChar) ? password : this.password;
	}
	
	public void setPassword(String password) {
		String newPassword = validatePasswordFormat(password);
		
		if (password.length() > 7) {
			this.password = newPassword;
		}
	}
	
}

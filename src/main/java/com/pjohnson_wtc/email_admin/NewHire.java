package com.pjohnson_wtc.email_admin;

import java.util.Objects;
import java.util.logging.*;

//Class for new hires
public class NewHire {
	
	Logger logger = Logger.getLogger("com.pjohnson_wtc.email_admin.newhire");
	
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
  
	//NEW until 75 - overrides for equals and hashCode
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewHire newHire = (NewHire) o;
        return Objects.equals(firstName, newHire.firstName) &&
                Objects.equals(lastName, newHire.lastName) &&
                Objects.equals(email, newHire.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }
	
	//NEW until 157
	//Validation for alternate email format
	private String validateAlternateEmail(String alternateEmail) {
			
		//Minimum length: @ + . + top level domain => 4, plus >= one character each for username and domain
		if (alternateEmail.contains("@") &&
			alternateEmail.contains(".") &&
			(alternateEmail.length() > 5) &&
			!(alternateEmail.substring(alternateEmail.length() -2).contains("@")) &&
			!(alternateEmail.substring(alternateEmail.length() -2).contains(".")) &&
			(alternateEmail.charAt(0) != '@') &&
			(alternateEmail.charAt(0) != '.')) {
				
			//If all checks pass, return email that has been passed as argument
			return alternateEmail;
		}
		//Otherwise, return alternateEmail from object
		logger.log(Level.WARNING, "Invalid email format");
		return this.alternateEmail;
	}
		
	//Setter for alternate email - set to output of validateAlternateEmail
	public void setAlternateEmail(String alternateEmail) {

		this.alternateEmail = validateAlternateEmail(alternateEmail);
	}
		
	//Setter for new mailbox capacity
	public void setMailboxCapacity(int mailboxCapacity) {
			
		//New capacity must be a positive number
		if (mailboxCapacity > 0) {
			this.mailboxCapacity = mailboxCapacity;
		} else {
			logger.log(Level.WARNING, "Mailbox capacity must be a positive number.");
		}
	}
		
	//Validate password format
	private String validatePasswordFormat(String password) {
			
		//Split password into charArray
		char[] passwordLetters = password.toCharArray();

		//Initialize booleans as false for validation criteria
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasNumber = false;
		boolean hasSpecialChar = false;
			
		//Loop through char array, evaluating each character and updating validation booleans as appropriate
		for (char letter : passwordLetters) {
			if (Character.isUpperCase(letter)) {
				hasUpperCase = true;
			}
			if (Character.isLowerCase(letter)) {
				hasLowerCase = true;
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
			
		//If all four conditions are met, we are allowed to proceed with the new password
		if (hasUpperCase && 
			hasLowerCase && 
			hasNumber && 
			hasSpecialChar && 
			(password.length() > 7)) {
			
			return password; 
			
		} else {
			
			logger.log(Level.WARNING, "Password must contain upper case, lower case, number and special character.");
			return this.password;
			
		}
	}
		
	//Setter for new password
	public void setPassword(String password) {
			
		//Check that new password has all of the required character types
		this.password = validatePasswordFormat(password);
		
	}

	//Necessary getters
	
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
}

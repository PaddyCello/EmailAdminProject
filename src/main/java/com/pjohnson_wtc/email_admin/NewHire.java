package com.pjohnson_wtc.email_admin;

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
	
	//Setter for alternate email
	public void setAlternateEmail(String alternateEmail) {

		//Format validation
		//In terms of minimum length, @ + . + top level domain = at least 4, plus at least one character each for username and domain
		if (alternateEmail.contains("@") &&
			alternateEmail.contains(".") &&
			(alternateEmail.length() > 5) &&
			!(alternateEmail.substring(alternateEmail.length() -2).contains("@")) &&
			!(alternateEmail.substring(alternateEmail.length() -2).contains(".")) &&
			(alternateEmail.charAt(0) != '@') &&
			(alternateEmail.charAt(0) != '.')) {
			
			this.alternateEmail = alternateEmail;

		}
	}
	
	//Setter for new mailbox capacity
	public void setMailboxCapacity(int mailboxCapacity) {
		
		//New capacity must be a positive number
		if (mailboxCapacity > 0) {
			this.mailboxCapacity = mailboxCapacity;
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
		return (hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar) ? password : this.password;
	}
	
	//Setter for new password
	public void setPassword(String password) {
		
		//Check that new password has all of the required character types
		String newPassword = validatePasswordFormat(password);
		
		//Check that password is at least eight characters long
		if (password.length() > 7) {
			this.password = newPassword;
		}
	}
	
}

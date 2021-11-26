package com.pjohnson_wtc.email_admin;

//Class for new hires
public class NewHire {
	
	//Instance variables - mailboxCapacity is initially given a default value
	private String firstName;
	private String lastName;
	private String email;
	private String alternateEmail;
	private int mailboxCapacity = 2000000;
	private String password;
	
	//Constructor - will be called from within Admin.createNewHire()
	public NewHire(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	//Necessary getters and setters
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	//Include validity check? (eg check for @ sign)
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public void setMailboxCapacity(int mailboxCapacity) {
		
		//Setter only updates mailboxCapacity if number is positive
		//Would it be better to have this method throw an Exception if number is less than zero?
		if (mailboxCapacity > 0) {
			this.mailboxCapacity = mailboxCapacity;
		} else {
			System.out.println("Mailbox capacity must be greater than zero.");
		}
	}
	
	//Need getter for testing purposes, can remove after
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Password generator
	public void generatePassword() {
		//TODO
	}
	
	//Method for displaying name, email and mailbox capacity
	//May not be needed - project brief requested get methods, plural
	public String showInfo() {
		
		return "Name: " + firstName + " " + lastName + ", Email: " + email + ", Mailbox Capacity: " + mailboxCapacity + "MB";
	}
	
}

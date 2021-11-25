package com.pjohnson_wtc.email_admin;

public class NewHire {
	private String firstName;
	private String lastName;
	private String email;
	private String alternateEmail;
	private int mailboxCapacity;
	private String password;
	
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
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Password generator
	public void generatePassword() {
		//TODO
	}
	
	//Method for displaying info
	public String showInfo() {
		//TODO
		return "coming soon...";
	}
	
}
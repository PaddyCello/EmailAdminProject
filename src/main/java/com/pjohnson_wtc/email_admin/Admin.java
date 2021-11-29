package com.pjohnson_wtc.email_admin;

public class Admin {
	
	private String[] departments = {"sales", "development", "accounting"};
	
	public String[] getDepartments() {
		return departments;
	}
	
	public String createNewHire(String firstName, String lastName, String department) {
		return "yay";
	}
	
}

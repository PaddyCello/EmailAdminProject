package com.pjohnson_wtc.email_admin;

public class Admin {
	
	private String[] departments = {"sales", "development", "accounting"};
	
	public String[] getDepartments() {
		return departments;
	}
	
	public String createNewHire(String firstName, String lastName, String department) {
		NewHire newHire = new NewHire(firstName, lastName, department);
		return newHire.getDepartment() != null ? (newHire.getFirstName() + "." + newHire.getLastName() + "@" + newHire.getDepartment() + ".company.com").toLowerCase() : (newHire.getFirstName() + "." + newHire.getLastName() + "@company.com").toLowerCase() ;
	}
	
}

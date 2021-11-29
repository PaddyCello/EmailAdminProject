package com.pjohnson_wtc.email_admin;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	
	private String[] departments = {"sales", "development", "accounting"};
	private List<NewHire> allNewHires = new ArrayList<NewHire>();
	
	public String[] getDepartments() {
		return departments;
	}
	
	public List<NewHire> getAllNewHires() {
		return allNewHires;
	}
	
	public String createNewHire(String firstName, String lastName, String department) {
		NewHire newHire = new NewHire(firstName, lastName, department);
		allNewHires.add(newHire);
		return newHire.getEmail();
	}
	
}

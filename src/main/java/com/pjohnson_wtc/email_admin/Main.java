package com.pjohnson_wtc.email_admin;

public class Main {

	public static void main(String[] args) {
		Admin admin = new Admin();
		
		String adamMinistrator = admin.createNewHire("Adam", "Ministrator", "Development");
		String annGineer = admin.createNewHire("Ann", "Gineer", "Development");
		
		System.out.println(adamMinistrator);
		System.out.println(annGineer);
		
		System.out.println(admin.getAllNewHires());
	}

}

package com.pjohnson_wtc.email_admin;

import java.util.logging.*;

public class Main {
	
	private static Logger logger = Logger.getAnonymousLogger();
	private static Handler consoleHandler = new ConsoleHandler();

	public static void main(String[] args) {
		
		logger.setLevel(Level.ALL);
		consoleHandler.setLevel(Level.ALL);
		logger.addHandler(consoleHandler);
		
		logger.info("Starting log");
		
		try {
			Admin admin = new Admin();
			
			String adamMinistrator = admin.createNewHire("Adam", "Ministrator", "Development");
			String annGineer = admin.createNewHire("Ann", "Gineer", "Development");
			String mikeRosoft = admin.createNewHire("Mike", "Rosoft", "Office");
		
			System.out.println(adamMinistrator);
			System.out.println(annGineer);
		
		
			System.out.println(admin.getAllNewHires());
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not create object from constructor", e);
		}
		
		logger.fine("Done");
	}

}

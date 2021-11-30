package com.pjohnson_wtc.email_admin;

import java.io.IOException;
import java.util.List;
import java.util.logging.*;
import java.util.stream.Collectors;

public class Main {
	
	//Create new Logger and ConsoleHandler
	private static Logger logger = Logger.getAnonymousLogger();
	private static Handler consoleHandler = new ConsoleHandler();
	
	public static void main(String[] args) throws IOException {
		
		//Create new FileHandler - had to do in main() so an IOException is throwable
		FileHandler fileHandler = new FileHandler("logfile.txt");
		
		//Set logging levels for Logger, ConsoleHandler and FileHandler
		logger.setLevel(Level.ALL);
		consoleHandler.setLevel(Level.ALL);
		fileHandler.setLevel(Level.ALL);
		
		//Set formatter for FileHandler so output is text and not XML
		fileHandler.setFormatter(new SimpleFormatter());

		//Add handlers to Logger
		logger.addHandler(consoleHandler);
		logger.addHandler(fileHandler);
		
		logger.info("Starting log");
		
		//Create Admin and test objects - have these all in the same try block for scope reasons
		try {
			Admin admin = new Admin();
			
			String adamMinistrator = admin.createNewHire("Adam", "Ministrator", "Development");
			String annGineer = admin.createNewHire("Ann", "Gineer", "Development");
			String mikeRosoft = admin.createNewHire("Mike", "Rosoft", "Office");
		
			System.out.println(adamMinistrator);
			System.out.println(annGineer);
			
			//Will build this into an Admin method in future
			NewHire trialNewHire = admin.getAllNewHires().stream().filter(x -> x.getEmail().equals(adamMinistrator)).collect(Collectors.toList()).get(0);
			
			//Test out getters for NewHire
			System.out.println(trialNewHire.getFirstName());
			System.out.println(trialNewHire.getLastName());
			System.out.println(trialNewHire.getDepartment());
			System.out.println(trialNewHire.getMailboxCapacity());
		
			//Test out getters for Admin
			String[] adminDepts = admin.getDepartments();
			for (String dept : adminDepts) {
				System.out.println(dept);
			}
			List<NewHire> trialHires = admin.getAllNewHires();
			for (NewHire hire : trialHires) {
				System.out.println(hire);
			}
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not create object from constructor", e);
		}
		
		logger.fine("Done");
	}

}

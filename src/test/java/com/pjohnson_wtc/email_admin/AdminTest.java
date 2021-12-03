package com.pjohnson_wtc.email_admin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminTest {
	
	@Mock
	NewHire newHire;
	
	@InjectMocks
	Admin admin;

	@Test
	public void testCreateNewHire_fullEmailFormat() {
		assertEquals("bob.jones@accounting.company.com", admin.createNewHire("Bob", "Jones", "Accounting"));
	}
	@Test
	public void testCreateNewHire_noDepartmentEmailFormat() {
		assertEquals("jim.smith@company.com", admin.createNewHire("Jim", "Smith", null));
	}
	@Test
	public void testCreateNewHire_addsToListOfHires() {
		admin.createNewHire("John", "Wayne", null);
		assertEquals("John", admin.getAllNewHires().get(2).getFirstName());
	}
	@Test
	public void testCreateNewHire_missingName() {
		assertEquals("Invalid format", admin.createNewHire(null, "Johnson", "Sales"));
	}
	@Test
	public void testCreateNewHire_invalidDepartment() {
		assertEquals("Department not listed", admin.createNewHire("Mike", "Rosoft", "Office"));
	}
	
	//Tests for WTCET-16 - generate password
	//At the moment, can only test this method with failing tests, purely so I can compare outputs manually
	@Test
	public void testGeneratePassword_returnsValue() {
		admin.createNewHire("John", "Wayne", null);
		assertEquals("password", admin.getAllNewHires().get(0).getPassword());
	}
	@Test
	public void testGeneratePassword_checkLengthGenerated() {
		assertEquals(10, admin.getAllNewHires().get(0).getPassword().length());
	}
}

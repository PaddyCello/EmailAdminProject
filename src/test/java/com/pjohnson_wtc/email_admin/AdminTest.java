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
		assertEquals("John", admin.getAllNewHires().get(1).getFirstName());
	}
	@Test
	public void testCreateNewHire_missingName() {
		assertEquals("Invalid format", admin.createNewHire(null, "Johnson", "Sales"));
	}
	@Test
	public void testCreateNewHire_invalidDepartment() {
		assertEquals("Department not listed", admin.createNewHire("Mike", "Rosoft", "Office"));
	}
	@Test
	public void testCreateNewHire_passwordAutoGenerated() {
		admin.createNewHire("John", "Wayne", null);
		assertNotNull(admin.getAllNewHires().get(1).getPassword());
	}
	@Test
	public void testSetAlternateEmail_correctEmailFormat() {
		admin.createNewHire("John", "Wayne", null);
		admin.getAllNewHires().get(0).setAlternateEmail("dummy@dummy.com");
		assertEquals("dummy@dummy.com", admin.getAllNewHires().get(0).getAlternateEmail());
	}
	@Test
	public void testSetAlternateEmail_incorrectFormat() {
		admin.createNewHire("John", "Wayne", null);
		admin.getAllNewHires().get(1).setAlternateEmail("dummy");
		assertNull(admin.getAllNewHires().get(1).getAlternateEmail());
	}
	@Test
	public void testSetMailboxCapacity_positiveNumber() {
		admin.createNewHire("John", "Wayne", null);
		admin.getAllNewHires().get(0).setMailboxCapacity(10);
		assertEquals(10, admin.getAllNewHires().get(0).getMailboxCapacity());
	}
	@Test
	public void testSetMailboxCapacity_numberZeroOrLess() {
		admin.createNewHire("John", "Wayne", null);
		admin.getAllNewHires().get(1).setMailboxCapacity(-10);
		assertEquals(2000000, admin.getAllNewHires().get(1).getMailboxCapacity());
	}
}

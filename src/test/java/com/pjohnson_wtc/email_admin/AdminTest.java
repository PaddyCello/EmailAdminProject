
package com.pjohnson_wtc.email_admin;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

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
		assertEquals("John", admin.getAllNewHires().get(0).getFirstName());
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
	public void testGetAllHires() {
		admin.createNewHire("John", "Wayne", null);
		admin.createNewHire("Jim", "Jones", "Accounting");
		assertThat(admin.getAllNewHires(), hasItems(new NewHire("John", "Wayne", null), new NewHire("Jim", "Jones", "Accounting")));
	}
}

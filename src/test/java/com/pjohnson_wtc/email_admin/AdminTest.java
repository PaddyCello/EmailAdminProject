package com.pjohnson_wtc.email_admin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

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
	public void testCreateNewHire_emailFormat() {
		assertEquals("bob.jones@accounting.company.com", admin.createNewHire("Bob", "Jones", "Accounting"));
	}
	@Test
	public void testCreateNewHire_nullDepartment() {
		assertEquals("jim.smith@company.com", admin.createNewHire("Jim", "Smith", null));
	}

}

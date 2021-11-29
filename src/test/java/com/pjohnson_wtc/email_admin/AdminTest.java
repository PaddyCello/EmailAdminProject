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
	public void testCreateNewHire() {
		assertEquals("yay", admin.createNewHire("Bob", "Jones", "Accounting"));
	}

}

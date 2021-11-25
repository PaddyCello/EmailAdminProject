package com.pjohnson_wtc.email_admin;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NewHireTest {

	NewHire newHire;
	
	@Before
	public void setup() {
		newHire = new NewHire("Bob", "Jones", "bob.jones@accounting.company.com");
	}
	
	@Test
	public void testGetMailboxCapacity_default() {
		assertEquals(2000000, newHire.getMailboxCapacity());
	}
	@Test
	public void testSetMailboxCapacity() {
		newHire.setMailboxCapacity(300);
		assertEquals(300, newHire.getMailboxCapacity());
	}
	@Test
	public void testSetMailboxCapacity_negativeNumber() {
		newHire.setMailboxCapacity(-20);
		assertEquals(2000000, newHire.getMailboxCapacity());
	}
	@Test
	public void testShowInfo() {
		assertEquals("Name: Bob Jones, Email: bob.jones@accounting.company.com, Mailbox Capacity: 2000000MB", newHire.showInfo());
	}

	@After
	public void teardown() {
		newHire = null;
		assertNull(newHire);
	}
}

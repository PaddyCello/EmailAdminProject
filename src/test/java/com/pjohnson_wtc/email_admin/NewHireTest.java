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
		newHire.setAlternateEmail("bob.jones@house.co.uk");
		newHire.setPassword("OktaHatesMe");
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals("Bob", newHire.getFirstName());
	}
	
	@Test
	public void testGetLastName() {
		assertEquals("Jones", newHire.getLastName());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("bob.jones@accounting.company.com", newHire.getEmail());
	}
	
	@Test
	public void testGetAlternateEmail() {
		assertEquals("bob.jones@house.co.uk", newHire.getAlternateEmail());
	}
	
	@Test
	public void testSetAlternateEmail() {
		newHire.setAlternateEmail("bob.jones@home.com");
		assertEquals("bob.jones@home.com", newHire.getAlternateEmail());
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
	public void testSetMailboxCapacity_zero() {
		newHire.setMailboxCapacity(0);
		assertEquals(2000000, newHire.getMailboxCapacity());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("OktaHatesMe", newHire.getPassword());
	}
	
	@Test
	public void testSetPassword() {
		newHire.setPassword("SaveMeITSupport!");
		assertEquals("SaveMeITSupport!", newHire.getPassword());
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

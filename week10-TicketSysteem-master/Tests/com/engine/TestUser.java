package com.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestUser {

	@Test
	void testUserConstructor() {
		User user = new User("name", "familyName", "17/11/2018");
		assertEquals("name", user.getName());
		assertEquals("familyName", user.getFamilyName());
		assertEquals("17/11/2018", user.getBirthDay());
	}
	
	@Test
	void testGeneratedKeySignature() {
		User user = new User("name", "familyName", "17/11/2018");
		assertEquals("U-", user.getID().substring(0, 2));
	}
	
	@Test
	void testGeneratedKeyNumberLength() {
		User user = new User("name", "familyName", "17/11/2018");
		assertEquals(6, user.getID().substring(2).length());
	}
	
	@Test
	void testGeneratedKeyLength() {
		User user = new User("name", "familyName", "17/11/2018");
		assertEquals(8, user.getID().length());
	}
	
	@Test
	void testPremiumStatus() {
		User user = new User("name", "familyName", "17/11/2018");
		user.setPremium(true);
		assertEquals(true, user.isPremium());
	}
	
	@Test
	void testDefaultPremiumStatus() {
		User user = new User("name", "familyName", "17/11/2018");
		assertEquals(false, user.isPremium());
	}

}

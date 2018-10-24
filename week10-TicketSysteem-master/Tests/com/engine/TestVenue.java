package com.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVenue {

	@Test
	void testVenueConstructor() {
		Venue venue = new Venue("BigMountain", "SmallStreet", 50, "0495", "NoMansTown", 2500);
		assertEquals("BigMountain", venue.getName());
		assertEquals("SmallStreet", venue.getStreetName());
		assertEquals(50, venue.getNumber());
		assertEquals("0495", venue.getPostCode());
		assertEquals("NoMansTown", venue.getTown());
		assertEquals(2500, venue.getCapacity());
	}
	
	@Test
	void testGeneratedKeySignature() {
		Venue venue = new Venue("BigMountain", "SmallStreet", 50, "0495", "NoMansTown", 2500);
		assertEquals("V-", venue.getID().substring(0, 2));
	}
	
	@Test
	void testGeneratedKeyLength() {
		Venue venue = new Venue("BigMountain", "SmallStreet", 50, "0495", "NoMansTown", 2500);
		assertEquals(6, venue.getID().length());
	}
	
	@Test
	void testGeneratedKeyNumberLength() {
		Venue venue = new Venue("BigMountain", "SmallStreet", 50, "0495", "NoMansTown", 2500);
		assertEquals(4, venue.getID().substring(2).length());
	}

}
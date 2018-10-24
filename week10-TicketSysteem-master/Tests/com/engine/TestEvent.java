package com.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEvent {

	private Event event;
	private Venue venue;
	
	@Test
	void testEventConstructor() {
		initialiseObjects();
		assertEquals("CoLchElla", event.getName());
		assertEquals("30/09/2020", event.getDate());
		assertEquals("21:00", event.getTime());
		assertEquals("OpenDoor festival for young and old", event.getDescription());
		assertEquals(29.99, event.getPrice());
	}
	
	@Test
	void testGeneratedKeySignature() {
		initialiseObjects();
		assertEquals("COL-", event.getID().substring(0, 4));
	}
	
	@Test
	void testGeneratedKeyNumberLength() {
		initialiseObjects();
		assertEquals(5, event.getID().substring(4).length());
	}
	
	@Test
	void testGeneratedKeyLength() {
		initialiseObjects();
		assertEquals(9, event.getID().length());
	}
	
	@Test
	void testAddEventLocation() {
		initialiseObjects();
		event.setLocation(venue);
		assertEquals(venue, event.getLocation());
	}
	
	private void initialiseObjects() {
		event = new Event("CoLchElla", "30/09/2020", "21:00", "OpenDoor festival for young and old", 29.99);
		venue = new Venue("BigMountain", "SmallStreet", 50, "0495", "NoMansTown", 2500);
	}

}
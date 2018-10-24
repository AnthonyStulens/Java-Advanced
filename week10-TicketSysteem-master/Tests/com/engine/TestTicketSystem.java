package com.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

class TestTicketSystem {

	Event geelStaHeet;
	Event tomorrowLand;
	Event tombola;
	Venue locationBoom;
	Venue locationGeel;
	User userMarie;
	User userStefani;
	TicketSystem system;
	
	@Test
	void testTicketRequest() {
		init();
		system.requestTicket(userMarie.getID(), geelStaHeet.getID());
		assertEquals(userMarie.getID(), system.viewNext(geelStaHeet.getID()));
	}
	
	@Test
	void testEventByName() {
		init();
		String[] lookup = system.getEventByName("Tom").split(";");
		assertEquals(2, lookup.length);
		if (lookup[0].equalsIgnoreCase("tomorrowland")) {
			assertEquals("TomorrowLand", lookup[0]);
			assertEquals("Tombola", lookup[1]);
		}
		if (lookup[0].equalsIgnoreCase("tombola")) {
			assertEquals("Tombola", lookup[0]);
			assertEquals("TomorrowLand", lookup[1]);
		}			
	}
	
	@Test
	void testAllFullEvents() {
		init();
		fail("Not implemented yet!");
	}
	
	@Test
	void testUsersByQueue() {
		init();
		fail("Not implemented yet!");
	}
	
	@Test
	void testUsersByTicket() {
		init();
		fail("Not implemented yet!");
	}
	
	@Test
	void testNextWeekEvents() {
		init();
		fail("Not implemented yet!");
	}

	private void init() {
		geelStaHeet = new Event("GeelStaHeet", "25/03/2018", "22:00", "Knalllueeeeh", 99.99);
		tomorrowLand = new Event("TomorrowLand", "26/07/2018", "8:00", "Yesterday is history", 124.99);
		tombola = new Event("Tombola", "23/12/2017", "16:00", "winnnneeuh", 4.99);
		locationGeel = new Venue("Geel", "Steegje in geel", 5, "0000", "Geel", 2000);
		locationBoom = new Venue("Boom", "tree", 33, "1234", "baum", 14300);
		userMarie = new User("Marie", "Buh", "21/01/2001");
		userStefani = new User("Stefani", "bruuuh", "15/09/1997");
		system = new TicketSystem();
		system.addEvent(tombola);
		system.addEvent(tomorrowLand);
		system.addEvent(geelStaHeet);
		system.addLocation(locationGeel);
		system.addLocation(locationBoom);
		system.addUser(userMarie);
		system.addUser(userStefani);
		tombola.setLocation(locationGeel);
		geelStaHeet.setLocation(locationGeel);
		tomorrowLand.setLocation(locationBoom);
	}
	
}

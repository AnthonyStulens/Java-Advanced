package com.engine;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestQueueService {
	
	private QueueService qs;
	private User michael;
	private User steffen;
	private User erdogan;
	private Event cross;
	private Event run;
	private Event prop;
	private Venue location;
	
	@Test
	void testGetNextInLine() {
		initializeObjects();
		try {
			qs.addToQueue(michael, cross);
			qs.addToQueue(steffen, cross);
			qs.addToQueue(erdogan, run);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(michael.getID(), qs.getNextInLine(cross).getID());
		assertEquals(steffen.getID(), qs.getNextInLine(cross).getID());
		assertEquals(null, qs.getNextInLine(cross));
		assertEquals(erdogan.getID(), qs.getNextInLine(run).getID());
	}
	
	@Test
	void testGetQueuedUsers() {
		initializeObjects();
		try {
			qs.addToQueue(erdogan, prop);
			qs.addToQueue(steffen, prop);
			qs.addToQueue(michael, cross);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(erdogan.getID() + ";" + steffen.getID() + ";", qs.getQueuedUsers(prop));
		assertEquals(michael.getID() + ";", qs.getQueuedUsers(cross));
	}
	
	@Test
	void testGetQueueLength() {
		initializeObjects();
		try {
			qs.addToQueue(steffen, prop);
			qs.addToQueue(erdogan, prop);
			qs.addToQueue(michael, cross);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(2, qs.getQueueLength(prop));
		assertEquals(1, qs.getQueueLength(cross));
	}
	
	@Test
	void testPremiumUserQueue() {
		initializeObjects();
		michael.setPremium(true);
		try {
			qs.addToQueue(erdogan, run);
			qs.addToQueue(michael, run);
			qs.addToQueue(steffen, run);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(michael.getID() + ";"
				+ erdogan.getID() + ";"
				+ steffen.getID() + ";", qs.getQueuedUsers(run));
	}
	
	@Test
	void testPremiumUserNextInLine() {
		initializeObjects();
		michael.setPremium(true);
		steffen.setPremium(true);
		try {
			qs.addToQueue(erdogan, run);
			qs.addToQueue(michael, run);
			qs.addToQueue(steffen, run);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(michael, qs.getNextInLine(run));
		assertEquals(steffen, qs.getNextInLine(run));
		assertEquals(erdogan, qs.getNextInLine(run));
	}
	
	@Test
	void testMultiplePremiumQueues() {
		initializeObjects();
		michael.setPremium(true);
		steffen.setPremium(true);
		try {
			qs.addToQueue(erdogan, prop);
			qs.addToQueue(michael, run);
			qs.addToQueue(steffen, cross);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(erdogan, qs.getNextInLine(prop));
		assertEquals(null, qs.getNextInLine(prop));
		assertEquals(michael, qs.getNextInLine(run));
		assertEquals(null, qs.getNextInLine(run));
		assertEquals(steffen, qs.getNextInLine(cross));
		assertEquals(null, qs.getNextInLine(cross));
	}
	
	@Test
	void testFullQueueList() {
		initializeObjects();
		try {
			qs.addToQueue(erdogan, run);
			qs.addToQueue(michael, run);
			qs.addToQueue(steffen, run);
			qs.addToQueue(new User("?", "?", "?"), run);
		} catch (Exception e) {
			return;
		}
		fail("This should give an exception!");
	}
	
	@Test
	void testQueueRemoveUser() {
		initializeObjects();
		try {
			qs.addToQueue(erdogan, run);
			qs.addToQueue(michael, run);
			qs.addToQueue(steffen, run);
			qs.getNextInLine(run);
			qs.addToQueue(new User("?", "?", "?"), run);
		} catch (Exception e) {
			fail("This should not give an exception!");
		}
	}
	
	private void initializeObjects() {
		qs = new QueueService();
		michael = new User("Michael", "Tielen", "10/11/1994");
		steffen = new User("Steffen", "Jabloski", "01/04/1999");
		erdogan = new User("Erdogan", "Dinç", "12/07/1990");
		cross = new Event("Cross", "18/12/2017", "20:00", "", 27.99);
		run = new Event("Run", "20/12/2017", "22:00", "Get fit!", 9.99);
		prop = new Event("Prop", "31/12/2017", "23:59", "Get ready to party", 49.99);
		location = new Venue("Versus", "idk", 0, "0000", "Hasselt", 3);
		cross.setLocation(location);
		run.setLocation(location);
		prop.setLocation(location);
	}

}

package com.engine;

import java.util.SortedMap;

import com.engine.map.EventMapper;
import com.engine.map.UserMapper;
import com.engine.map.VenueMapper;

/**
 * Represents the main engine of this software, processes all tickets.
 */
public class TicketSystem {

	private QueueService queueService;
	private SortedMap<String, User> users = new UserMapper().getList();
	private SortedMap<String, Event> events = new EventMapper().getList();
	private SortedMap<String, Venue> locations = new VenueMapper().getList();
	
	/**
	 * Initialize an instance of the ticket system
	 */
	public TicketSystem() {
		queueService = new QueueService();
	}
	
	/**
	 * Places an user in the queue for the requested event
	 * @param user - user object
	 * @param event - event object
	 */
	public void requestTicket(String userID, String eventID) {
		try {
			queueService.addToQueue(users.get(userID), events.get(eventID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * returns the id of the first user in front of this queue
	 * @param eventID - event id number
	 * @return name of first user in line
	 */
	public String viewNext(String eventID) {
		return queueService.getNextInLine(events.get(eventID)).getID();
	}
	
	/**
	 * lookup events by name
	 * <pre>Key Sensitive!</pre>
	 * @param eventName - event name
	 * @return string of events
	 */
	public String getEventByName(String eventName) {
		String result = "";
		for (Event event : events.values()) {
			if (event.getName().contains(eventName))
				result += event.getName() + ";";
		}
		return result;
	}
	
	/**
	 * create a list of all events which are full
	 * <pre>Key Sensitive!</pre>
	 * @return string of events
	 */
	public String getAllFullEvents() {
		String result = "";
		for (Event event : events.values()) {
			if (event.isFull())
				result += event.getName() + ";";
		}
		return result;
	}
	
	/**
	 * create a list of all queues an user is presented in
	 * <pre>Key Sensitive!</pre>
	 * @param userID - user id
	 * @return string of events
	 */
	public String getUserQueues(String userID) {
		String result = "";
		for (Event event : events.values()) {
			if (event.getList().contains(users.get(userID)))
				result += event.getName() + ";";
		}
		return result;
	}
	
	//TODO implement, events where user owns tickets from
	public String getUserTickets(String userID) {
		return null;
	}
	
	//TODO implement, all locations where in next 7 days an event is planned
	public String getNextWeeksEvents() {
		return null;
	}
	
	public void assignLocationToEvent(String locationID, String eventID) {
		events.get(eventID).setLocation(locations.get(locationID));
	}
	
	/**
	 * adds an user to the current user list
	 * @param user - user object
	 */
	public void addUser(User user) {
		users.put(user.getID(), user);
	}
	
	/**
	 * adds an event to the current events list
	 * @param event - event object
	 */
	public void addEvent(Event event) {
		events.put(event.getID(), event);
	}
	
	/**
	 * adds a location to the current venue/location list
	 * @param location - Venue object
	 */
	public void addLocation(Venue location) {
		locations.put(location.getID(), location);
	}
	
	/**
	 * gets the user object depending on the requested user id
	 * @param userID - user id number
	 * @return user object
	 */
	public User getUser(String userID) {
		return users.get(userID);
	}
	
	/**
	 * gets the event object depending on the requested event id
	 * @param eventID - event id number
	 * @return event object
	 */
	public Event getEvent(String eventID) {
		return events.get(eventID);
	}
	
	/**
	 * gets the venue object depending on the requested location id
	 * @param locationID - venue/location id number
	 * @return venue object
	 */
	public Venue getLocation(String locationID) {
		return locations.get(locationID);
	}
	
}
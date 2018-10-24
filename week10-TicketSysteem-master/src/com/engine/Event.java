package com.engine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Random;

/**
 * Represents an event for bands, theater groups, ...
 */
public class Event {

	private String id;
	private String name;
	private String time;
	private String description;
	private double price;
	private Venue location;
	private LinkedList<User> users = new LinkedList<>();
	private LocalDate date;
	
	/**
	 * creates an event instance
	 * @param name - name for this event
	 * @param date - date for this event to start 'dd/MM/yyyy'
	 * @param time - time for this event to start 'HH:mm'
	 * @param description - description for this event
	 * @param price - cost for this event
	 */
	public Event(String name, String date, String time, String description, double price) {
		setName(name);
		generateID();
		setDate(date);
		setTime(time);
		setDescription(description);
		setPrice(price);
	}
	
	/**
	 * Check whether this event is full or not
	 * @return boolean value depending on event full or not
	 */
	public boolean isFull() {
		if (users.size() >= location.getCapacity())
			return true;
		return false;
	}
	
	/**
	 * generates an unique ID for this event
	 */
	private void generateID() {
		int number = new Random().nextInt(99999);
		/* TODO check if number already exists in this data log!
		 * while (number exists) {
		 *   Regenerate number
		 * }
		 */
		setID(name.substring(0, 3).toUpperCase() + "-" + String.format("%05d", number));
	}
	
	/**
	 * change the name for this event
	 * @param name - name for this event
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * request event name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * change date for this event to start
	 * @param date - date for this event to start 'dd/MM/yyyy'
	 */
	public void setDate(String date) {
		String[] value = date.split("/");
		this.date = LocalDate.of(Integer.parseInt(value[2]),
								Integer.parseInt(value[1]), 
								Integer.parseInt(value[0]));
	}
	
	/**
	 * request event start date
	 * @return date
	 */
	public String getDate() {
		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	/**
	 * request date object
	 * @return date
	 */
	public LocalDate getDateObject() {
		return date;
	}
	
	/**
	 * change time for this event to start
	 * @param time - time for this event to start 'HH:mm'
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * request event start time
	 * @return time
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * change the description for this event
	 * @param description - description for this event
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * request event description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * change the price for this event
	 * @param price - price for this event
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * request the price for this event
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * set the id of this event
	 * @param id
	 */
	public void setID(String id) {
		this.id = id;
	}
	
	/**
	 * request the ID for this event
	 * @return id
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * request the users list
	 * @return users
	 */
	public LinkedList<User> getList() {
		return users;
	}
	
	/**
	 * add an user to this event
	 * @param user - user that will be participating in this event
	 */
	public void addUser(User user) {
		users.add(user);
	}
	
	/**
	 * set the location for this event
	 * @param locationID - location for this event
	 */
	public void setLocation(Venue location) {
		this.location = location;
	}
	
	/**
	 * request the location of this event
	 * @return location
	 */
	public Venue getLocation() {
		return location;
	}
}
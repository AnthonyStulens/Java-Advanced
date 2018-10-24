package com.engine;

import java.util.Random;

/**
 * Represents a concert or any other location.
 */
public class Venue {

	private String id;
	private String name;
	private String streetName;
	private String postCode;
	private String town;
	private int number;
	private int capacity;
	
	/**
	 * Create an instance of a venue
	 * @param name - name of this venue
	 * @param streetName - street name of this venue
	 * @param number - location number (house number) of this venue
	 * @param postCode - post code of this venue
	 * @param town - town of this venue
	 * @param capacity - how many people can this venue hold
	 */
	public Venue(String name, String streetName, int number, String postCode, String town, int capacity) {
		generateID();
		setName(name);
		setStreetName(streetName);
		setNumber(number);
		setPostCode(postCode);
		setTown(town);
		setCapacity(capacity);
	}
	
	/**
	 * Generates an unique ID for this user
	 */
	private void generateID() {
		int number = new Random().nextInt(9999);
		/* TODO check if number already exists in this data log!
		 * while (number exists) {
		 *   Regenerate number
		 * }
		 */
		setID("V-" + String.format("%04d", number));
	}
	
	/**
	 * change the name of this venue
	 * @param name - name of this venue
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * request name of this venue
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * change the street name of this venue
	 * @param streetName - street name of this venue
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	/**
	 * request street name of this venue
	 * @return streetName
	 */
	public String getStreetName() {
		return streetName;
	}
	
	/**
	 * change the location (house) number of this venue
	 * @param number - location (house) number of this venue
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * request location (house) number of this venue
	 * @return number
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * change postcode of this venue
	 * @param postCode - postcode of this venue
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	/**
	 * request postcode of this venue
	 * @return postCode
	 */
	public String getPostCode() {
		return postCode;
	}
	
	/**
	 * change town name of this venue
	 * @param town - town name of this venue
	 */
	public void setTown(String town) {
		this.town = town;
	}
	
	/**
	 * request town name of this venue
	 * @return town
	 */
	public String getTown() {
		return town;
	}
	
	/**
	 * change the capacity of this venue
	 * @param capacity - how many people fit in this venue
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * request the capacity of this venue
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * set the id of this event
	 * @param id
	 */
	public void setID(String id) {
		this.id = id;
	}
	
	/**
	 * request the ID of this venue
	 * @return id
	 */
	public String getID() {
		return id;
	}
	
}
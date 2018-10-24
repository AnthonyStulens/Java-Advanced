package com.engine;

import java.util.Random;

/**
 * Represents an user.
 */
public class User {

	private String id;
	private String name;
	private String familyName;
	private String birthDay;
	private boolean isPremium;
	
	/**
	 * Creates an user instance.
	 * @param name - name for this user
	 * @param familyName - family name for this user
	 * @param birthDay - birth date in following format 'dd/MM/yyyy'
	 */
	public User(String name, String familyName, String birthDay) {
		generateID();
		setName(name);
		setFamilyName(familyName);
		setBirthDay(birthDay);
	}
	
	/**
	 * Generates an unique ID for this user
	 */
	private void generateID() {
		int number = new Random().nextInt(999999);
		/* TODO check if number already exists in this data log!
		 * while (number exists) {
		 *   Regenerate number
		 * }
		 */
		setID("U-" + String.format("%06d", number));
	}
	
	/**
	 * change this users name
	 * @param name - name for the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * request users name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * change this users family name
	 * @param familyName - family name for this user
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	/**
	 * request users family name
	 * @return familyName
	 */
	public String getFamilyName() {
		return familyName;
	}
	
	/**
	 * change this users birth date
	 * @param birthDay - birth date in following format 'dd/MM/yyyy'
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	/**
	 * request users birth date
	 * @return birthDay
	 */
	public String getBirthDay() {
		return birthDay;
	}
	
	/**
	 * set the id of this event
	 * @param id - user id
	 */
	public void setID(String id) {
		this.id = id;
	}
	
	/**
	 * request users unique ID
	 * @return id
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * set the premium state of this user
	 * @param isPremium - premium state 'true'/'false'
	 */
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	
	/**
	 * request users premium state
	 * @return isPremium
	 */
	public boolean isPremium() {
		return isPremium;
	}
	
	/**
	 * Compare current user to different user<br><pre><code>
	 * 0: both are premium
	 * 1: current user is premium
	 * 2: both aren't premium
	 * </code></pre>
	 * @param user - user object
	 * @return compared value
	 * @author Dary Schaeken 
	 */
	public int compareTo(User user) {
		if (isPremium() == user.isPremium())
			return 0;
		else if (isPremium() == true)
			return 1;
		else
			return -1;
	}
}
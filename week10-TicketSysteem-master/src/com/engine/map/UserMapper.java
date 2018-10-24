package com.engine.map;

import java.util.SortedMap;
import java.util.TreeMap;

import com.Settings;
import com.engine.User;
import com.engine.io.Reader;

/**
 * Reads data from the user data log and puts them into this map
 */
public class UserMapper implements Mapper {
	
	private Reader reader = new Reader();
	private SortedMap<String, User> userList = new TreeMap<>();
	
	/**
	 * creates a list of all existing users
	 * @return list of all existing users
	 */
	public SortedMap<String, User> getList() {
		String[] users = reader.read(Settings.PATH_USERS).split(">");
		String[] current;
		for (int i = 0; i < users.length; i++) {
			current = users[i].split(";");
			userList.put(current[0], map(current));
		}
		return userList;
	}
	
	/**
	 * Converts the file date format to a proper format
	 * @param date - string of file date format 'ddMMyyyy'
	 * @return date format 'dd/MM/yyyy'
	 */
	private String dateFormat(String date) {
		return date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 6);
	}
	
	@Override
	public User map(String[] args) {
		User user = new User(args[1], args[2], dateFormat(args[3]));
		user.setID(args[0]);
		return user;
	}

}
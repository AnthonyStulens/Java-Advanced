package com.engine.map;

import java.util.SortedMap;
import java.util.TreeMap;

import com.Settings;
import com.engine.Venue;
import com.engine.io.Reader;

/**
 * Reads data from the concert/location data log and puts them into this map
 */
public class VenueMapper implements Mapper {

	private Reader reader = new Reader();
	private SortedMap<String, Venue> venueList = new TreeMap<>();
	
	/**
	 * creates a list of all existing locations
	 * @return list of all existing locations
	 */
	public SortedMap<String, Venue> getList() {
		String[] events = reader.read(Settings.PATH_VENUES).split(">");
		String[] current;
		for (int i = 0; i < events.length; i++) {
			current = events[i].split(";");
			venueList.put(current[0], map(current));
		}
		return venueList;
	}
	
	@Override
	public Venue map(String[] args) {
		Venue venue = new Venue(args[1], args[2], Integer.parseInt(args[3]), args[4], args[5], Integer.parseInt(args[6]));
		venue.setID(args[0]);
		return venue;
	}

}
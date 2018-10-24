package com.engine.map;

import java.util.SortedMap;
import java.util.TreeMap;

import com.Settings;
import com.engine.Event;
import com.engine.io.Reader;

/**
 * Reads data from the event data log and puts them into this map
 */
public class EventMapper implements Mapper {

	private Reader reader = new Reader();
	private SortedMap<String, Event> eventList = new TreeMap<>();
	
	/**
	 * creates a list of all existing events
	 * @return list of all existing events
	 */
	public SortedMap<String, Event> getList() {
		String[] events = reader.read(Settings.PATH_EVENTS).split(">");
		String[] current;
		for (int i = 0; i < events.length; i++) {
			current = events[i].split(";");
			eventList.put(current[0], map(current));
		}
		return eventList;
	}
	
	/**
	 * Converts the file date format to a proper format
	 * @param date - string of file date format 'ddMMyyyy'
	 * @return date format 'dd/MM/yyyy'
	 */
	private String dateFormat(String date) {
		return date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 6);
	}
	
	/**
	 * Converts the file time format to a proper time
	 * @param time - string of file time format 'HHmm'
	 * @return time fromat 'HH:mm'
	 */
	private String timeFormat(String time) {
		return time.substring(0, 2) + ":" + time.substring(2, 4);
	}
	
	@Override
	public Event map(String[] args) {
		Event event = new Event(args[2], dateFormat(args[1].substring(0, 8)), timeFormat(args[1].substring(8)), args[3], Double.parseDouble(args[4]));
		event.setID(args[0]);
		return event;
	}

}
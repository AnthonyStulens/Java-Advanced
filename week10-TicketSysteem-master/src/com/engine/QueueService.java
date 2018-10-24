package com.engine;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Keeps track of the queue list, for each event is one list.
 */
public class QueueService {

	//Using new TreeSet<User>((u1, u2) -> u1.compareTo(u2)), overrides the old value
	private HashMap<Event, LinkedList<User>> list = new HashMap<>();
	
	/**
	 * puts the user in a queue for a specific event
	 * @param user - object from the user that wants to join an event
	 * @param event - object from the event he wants to join
	 * @throws Exception 
	 */
	public void addToQueue(User user, Event event) throws Exception {
		if (event.getLocation() == null)
			throw new Exception("Event doesn't have a location yet!");
		if (event.isFull())
			throw new Exception("Event is full!");
		if (!list.containsKey(event))
			list.put(event, new LinkedList<User>());
		list.get(event).add(user);
		event.addUser(user);
		sortList(event);
	}
	
	/**
	 * returns the id of the first user in front of this queue
	 * @param event - requested event object
	 * @return first user object in this event queue
	 */
	public User getNextInLine(Event event) {
		event.getList().pollFirst();
		return list.get(event).pollFirst();
	}
	
	/**
	 * Prints all users queued in requested event
	 * @param event - requested event object
	 * @return queued user names
	 */
	public String getQueuedUsers(Event event) {
		String result = "";
		for (User user : list.get(event)) {
			result += user.getID() +  ";";
		}
		return result;
	}
	
	/**
	 * returns the queue size of a requested event
	 * @param event - requested event object
	 * @return list length
	 */
	public int getQueueLength(Event event) {
		return list.get(event).size();
	}
	
	/**
	 * replacement method which allows this current LinkedList
	 * to work as a TreeSet<>, Since that one is broken.
	 * This method will sort the list in premium order.
	 * @param event - event object
	 */
	private void sortList(Event event) {
		LinkedList<User> bkp = new LinkedList<>();
		for (User user : list.get(event)) {
			if (user.isPremium())
				bkp.add(user);
		}
		for (User user : list.get(event)) {
			if (!user.isPremium())
				bkp.add(user);
		}
		list.get(event).clear();
		list.get(event).addAll(bkp);
	}
	
	/**
	 * request the current queue list
	 * @return list
	 */
	public HashMap<Event, LinkedList<User>> getQueue() {
		return list;
	}
}
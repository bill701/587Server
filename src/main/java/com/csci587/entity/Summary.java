package com.csci587.entity;

import java.sql.Date;
import java.util.List;

public class Summary {

	private int summaryId;
	private Date startTime;
	private Date endTime;
	private User user;
	private List<Event> eventList;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Event> getEventList() {
		return eventList;
	}
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	
}

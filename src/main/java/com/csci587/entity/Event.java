package com.csci587.entity;

import java.sql.Date;

public class Event {
	private Location location;
	private int targetTime;
	private int actualTime;
	private Date dateTime;
	private int EventId;
	private User user;
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getTargetTime() {
		return targetTime;
	}
	public void setTargetTime(int targetTime) {
		this.targetTime = targetTime;
	}
	public int getActualTime() {
		return actualTime;
	}
	public void setActualTime(int actualTime) {
		this.actualTime = actualTime;
	}

	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getEventId() {
		return EventId;
	}
	public void setEventId(int eventId) {
		EventId = eventId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

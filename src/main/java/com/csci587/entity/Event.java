package com.csci587.entity;

public class Event {
	private Location location;
	private int targetTime;
	private int actualTime;
	private String date;
	private String EventId;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEventId() {
		return EventId;
	}
	public void setEventId(String eventId) {
		EventId = eventId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

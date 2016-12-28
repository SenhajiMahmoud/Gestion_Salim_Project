package com.Pizzeria.models;

public class Event {

	private String start_Event;
	private String end_Event;
	private String description;

	public Event() {
		super();
	}

	public Event(String start_Event, String end_Event, String description) {
		super();
		this.start_Event = start_Event;
		this.end_Event = end_Event;
		this.description = description;
	}

	public String getStart_Event() {
		return start_Event;
	}

	public void setStart_Event(String start_Event) {
		this.start_Event = start_Event;
	}

	public String getEnd_Event() {
		return end_Event;
	}

	public void setEnd_Event(String end_Event) {
		this.end_Event = end_Event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

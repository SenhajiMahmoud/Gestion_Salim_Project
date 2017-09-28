package com.Pizzeria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "events2")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column private int id;
//	@Column private String horaire;
	
	@Column private String start_Event;
	@Column private String end_Event;
	@Column private String description;
	
	public Event() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

//	public String getHoraire() {
//		return horaire;
//	}
//
//	public void setHoraire(String horaire) {
//		this.horaire = horaire;
//	}
	
	
}

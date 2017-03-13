package com.Pizzeria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "events")
public class Event {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column private int id;
	@Column private String horaire;
	
//	@Column private String start_Event;
//	@Column private String end_Event;
//	@Column private String description;
	
	public Event() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoraire() {
		return horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
}

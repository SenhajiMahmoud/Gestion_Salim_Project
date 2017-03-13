package com.Pizzeria.dao;


import com.Pizzeria.entities.Candidature;
import com.Pizzeria.entities.Event;

/**
 * @author Mahmoud
 *
 */
public interface ServicesDao {
	public int add(Candidature candidate);
	public String Event(int id);
	public void addEvent(Event eventEntity);
//	public List<Event> getEvent();
	
}

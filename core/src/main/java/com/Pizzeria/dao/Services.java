package com.Pizzeria.dao;

import java.util.List;

import com.Pizzeria.models.Candidature;
import com.Pizzeria.models.Event;

/**
 * @author Mahmoud
 *
 */
public interface Services {
	public int add(Candidature candidate);
	public List<Candidature> list();
	public List<Event> getEvent();
	
}

package com.Pizzeria.service;


import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.Dto.EventDto;

/**
 * @author Mahmoud
 *
 */
public interface PizzeriaServices {
	public void add(CandidatureDto candidate);
	public String listEvent(int id);
	public void addEvent(EventDto event);
//	public List<EventDto> getEvent();
	
}

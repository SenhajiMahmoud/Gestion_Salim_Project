package com.Pizzeria.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.Dto.EventDto;
import com.Pizzeria.converters.Convert;
import com.Pizzeria.dao.ServicesDao;
import com.Pizzeria.entities.Candidature;
import com.Pizzeria.entities.Event;


/**
 * @author Mahmoud
 *
 */
@Service
public class PizzeriaServicesImpl implements PizzeriaServices{
	
	@Autowired
	private ServicesDao dao;
	
	private Convert conv;
	public PizzeriaServicesImpl() {
		conv = new Convert();
	}
	
	@Override
	public void add(CandidatureDto candidate) {
		
		Candidature cand = conv.candidatureConvertToDao(candidate);
		dao.add(cand);
	}

	@Override
	public String listEvent(int id) {
		String Event = dao.Event(id);
		return Event;
	}

	@Override
	public void addEvent(EventDto event) {
		Event eventEntity = conv.EventDtaToDao(event);
		dao.addEvent(eventEntity);
	}

	 

//	@Override
//	public List<CandidatureDto> list() {
//		return dao.list();
//	}
//
//	@Override
//	public List<EventDto> getEvent() {
//		return dao.getEvent();
//	}

	 

}

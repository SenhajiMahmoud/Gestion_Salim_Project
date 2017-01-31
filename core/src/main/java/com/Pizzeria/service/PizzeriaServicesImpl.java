package com.Pizzeria.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.converters.Convert;
import com.Pizzeria.dao.ServicesDao;
import com.Pizzeria.entities.Candidature;


/**
 * @author Mahmoud
 *
 */
@Service
public class PizzeriaServicesImpl implements PizzeriaServices{
	
	@Autowired
	private ServicesDao dao;
	
	private  Convert conv;
	public PizzeriaServicesImpl() {
		conv = new Convert();
	}
	
	@Override
	public void add(CandidatureDto candidate) {
		
		Candidature cand = conv.candidatureConvertToDao(candidate);
		dao.add(cand);
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

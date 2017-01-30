package com.Pizzeria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.Dto.EventDto;
import com.Pizzeria.converters.Convert;
import com.Pizzeria.dao.ServicesDao;
import com.Pizzeria.entities.Candidature;


/**
 * @author Mahmoud
 *
 */
@Service
public class ServicesImpl implements Services{
	
	@Autowired
	private ServicesDao dao;
	
	private Convert conv;
	
	@Override
	public void add(CandidatureDto candidate) {
		System.out.println("ok");
		Candidature cand = conv.candidatureConvertToDao(candidate);
		System.out.println("ok2");
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

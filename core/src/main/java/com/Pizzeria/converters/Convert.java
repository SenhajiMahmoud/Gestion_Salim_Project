package com.Pizzeria.converters;

import java.util.ArrayList;
import java.util.List;

import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.Dto.EventDto;
import com.Pizzeria.entities.Candidature;
import com.Pizzeria.entities.Event;

public class Convert {
	
	 
		public Candidature candidatureConvertToDao(CandidatureDto candidate){
			Candidature entity = new Candidature() ;
			entity.setId(candidate.getId());
			entity.setCivilite(candidate.getCivilite());
			entity.setPoste(candidate.getPoste());
			return entity;
		}
		
		public List<EventDto> EventConvertToDto(List<Event> eventDao){
			List<EventDto> dto = new ArrayList<>();
			for (int i = 0; i < eventDao.size(); i++)  {
				dto.get(i).setId(eventDao.get(i).getId());
				dto.get(i).setHoraire(eventDao.get(i).getHoraire());
			}
			return dto;
		}
		
		public Event EventDtaToDao(EventDto event){
			Event entity = new Event();
			entity.setId(event.getId());
			entity.setHoraire(event.getHoraire());
			return entity;
		}
}

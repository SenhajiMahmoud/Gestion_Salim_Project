package com.Pizzeria.converters;

import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.entities.Candidature;

public class Convert {
		public Candidature candidatureConvertToDao(CandidatureDto candidate){
			Candidature entity = new Candidature() ;
			entity.setId(candidate.getId());
			entity.setCivilite(candidate.getCivilite());
			entity.setPoste(candidate.getPoste());
			
			return entity;
		}
}

package com.Pizzeria.converters;

import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.entities.Candidature;

public class Convert {
	
	 
		public Candidature candidatureConvertToDao(CandidatureDto candidate){
			System.out.println("ok2");
			Candidature entity = new Candidature() ;
			System.out.println("ok3");
			entity.setId(candidate.getId());
			entity.setCivilite(candidate.getCivilite());
			entity.setPoste(candidate.getPoste());
			System.out.println("ok4");
			return entity;
		}
}

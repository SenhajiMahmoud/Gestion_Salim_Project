package com.Pizzeria.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Pizzeria.entities.Candidature;



/**
 * @author Mahmoud
 *
 */
@Repository
public class ServicesDaoImpl implements ServicesDao{
	
	@Autowired
	private SessionFactory sf;
//	private String req = "select * from TB_candidature";

	

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

//	@Transactional
//	public List<Candidature> list() {
//		SQLQuery sql = sf.getCurrentSession().createSQLQuery(req);
//		sql.addEntity(Candidature.class);
//		List<Candidature> candidats = sql.list();
//		return candidats;
//	}
//
//	@Override
//	public List<Event> getEvent() {
//
//		return null;
//	}

	@Transactional
	public int add(Candidature candidate) {
		sf.getCurrentSession().save(candidate);
		return 1;
	}

}

package com.Pizzeria.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Pizzeria.entities.Candidature;
import com.Pizzeria.entities.Event;

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
	
	@Transactional
	public int add(Candidature candidate) {
		sf.getCurrentSession().save(candidate);
		return 1;
	}

	@Transactional
	public String Event(int id) {
		Event e = (Event) sf.getCurrentSession().load(Event.class, new Integer(id));
		return e.getHoraire();
	}

	@Override
	public void addEvent(Event eventEntity) {
		sf.getCurrentSession().save(eventEntity);
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
}

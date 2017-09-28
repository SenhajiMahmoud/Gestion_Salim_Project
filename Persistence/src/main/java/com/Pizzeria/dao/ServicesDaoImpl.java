package com.Pizzeria.dao;

import java.util.List;

import org.hibernate.Query;
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
		StringBuffer b = new StringBuffer();
//		Event e = (Event) sf.getCurrentSession().load(Event.class, new Integer(id));
		Query query = sf.getCurrentSession().createQuery("from events2 where id_client=1");
		List<Event> e = query.list();
		b.append("[");
		for (Event event : e) {
			
			b.append("{text:" + "\"" + event.getDescription() + "\"" + ", start_date:" + "\"" + event.getStart_Event() + "\"" 
					+ ", end_date:" + "\"" + event.getEnd_Event() + "\"},");
		}
		
		b.append("]");
		
//		System.out.println("json------>" + b.toString());
		
		return b.toString();
		
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

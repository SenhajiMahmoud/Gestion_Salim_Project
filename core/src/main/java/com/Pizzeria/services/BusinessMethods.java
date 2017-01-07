package com.Pizzeria.services;

import com.Pizzeria.models.Candidature;
import com.Pizzeria.models.Notification;

public interface BusinessMethods {
	public void envoiMailAdmin(String to, String from, Candidature d);
	public String factureConstruct(Notification notif);
	public void envoiMailCandidat(String to, String from, Candidature d);
	public void envoiMail(String to, String from, String infos);
}

package com.Pizzeria.Methods;

import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.Dto.NotificationDto;

public interface BusinessMethods {
	public void envoiMailAdmin(String to, String from, CandidatureDto d);
	public String factureConstruct(NotificationDto notif);
	public void envoiMailCandidat(String to, String from, CandidatureDto d);
	public void envoiMail(String to, String from, String infos);
}

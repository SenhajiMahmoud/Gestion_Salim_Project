package com.Pizzeria.business;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Pizzeria.dao.Services;
import com.Pizzeria.models.Candidature;
import com.Pizzeria.models.Notification;
import com.Pizzeria.models.TypeNotification;
import com.Pizzeria.services.BusinessMethods;
import com.Pizzeria.services.NotificationService;

/**
 * @author Mahmoud
 *
 */
@Controller
public class NotificationController{
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private Services service;
	
	@Autowired
	private BusinessMethods BMethods;
	
	
	@MessageMapping("/hello")
	@SendTo("/topic/notification")
	public NotificationService hello(Notification u) {
		System.out.println(u.getUserName() + '-' + u.getNotificationDescription());
		return new NotificationService(u.getUserName() + ',' + u.getNotificationDescription());
	}

	@RequestMapping("/envMessage")
	public String sendNotification(@RequestBody Notification u) throws MessagingException {
		String infos = "";

		switch (u.getTypeAlert()) {
		case Retard:
				infos = "Retard";
				System.out.println(infos);
			break;
		case detour:
			infos = "Detour";
			System.out.println(infos);
			break;
		case Facture:
				infos = BMethods.factureConstruct(u);
			break;
		default:
			System.out.println("Type_Alert_Introuvable");
			break;
		}
		if(u.getTypeAlert() == TypeNotification.Facture){
			System.out.println("------>Facture");
			BMethods.envoiMail("sema_ma@hotmail.fr", "Pizzeria_Win_Win@hotmail.com", infos);
		}
		template.convertAndSend("/topic/notification", new NotificationService(u.getUserName() + ',' + u.getNotificationDescription()));
		return "decNotif";
	}

	
}

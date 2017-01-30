package com.Pizzeria.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Pizzeria.Dto.NotificationDto;
import com.Pizzeria.Methods.BusinessMethods;
import com.Pizzeria.Methods.NotificationService;
import com.Pizzeria.service.PizzeriaServices;

/**
 * @author Mahmoud
 *
 */
@Controller
public class NotificationController{
	@Autowired
	private SimpMessagingTemplate template;
	
//	@Autowired
//	private PizzeriaServices service;
	
	@Autowired
	private BusinessMethods BMethods;
	
	
	@MessageMapping("/hello")
	@SendTo("/topic/notification")
	public NotificationService hello(NotificationDto u) {
		System.out.println(u.getUserName() + '-' + u.getNotificationDescription());
		return new NotificationService(u.getUserName() + ',' + u.getNotificationDescription());
	}

	@RequestMapping("/envMessage")
	public String sendNotification(@RequestBody NotificationDto u) throws MessagingException {
		String infos = "";

//		switch (u.getTypeAlert()) {
//		case Retard:
//				infos = "Retard";
//				System.out.println(infos);
//			break;
//		case detour:
//			infos = "Detour";
//			System.out.println(infos);
//			break;
//		case Facture:
//				infos = BMethods.factureConstruct(u);
//			break;
//		default:
//			System.out.println("Type_Alert_Introuvable");
//			break;
//		}
//		if(u.getTypeAlert() == TypeNotification.Facture){
//			System.out.println("------>Facture");
//			BMethods.envoiMail("sema_ma@hotmail.fr", "Pizzeria_Win_Win@hotmail.com", infos);
//		}
//		template.convertAndSend("/topic/notification", new NotificationService(u.getUserName() + ',' + u.getNotificationDescription()));
		return "decNotif";
	}

	
}

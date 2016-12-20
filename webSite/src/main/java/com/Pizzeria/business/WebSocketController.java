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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Pizzeria.models.Notification;
import com.Pizzeria.services.NotificationService;

/**
 * @author Mahmoud
 *
 */
@Controller()
public class WebSocketController {
	
	
	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/hello.h")
	@SendTo("/topic/notification")
	public NotificationService hello(Notification u) {
		System.out.println("ok");
		System.out.println(u.getName() + " - " + u.getMessage());

		return new NotificationService(u.getName() + ',' + u.getMessage());
	}
	
	@RequestMapping("/envMessage")
	public String Message(@RequestBody Notification u) throws MessagingException{
	 
		System.out.println("ok");
		template.convertAndSend("/topic/notification", new NotificationService(u.getName() + ',' + u.getMessage()));
		return "decNotif";
	}

}

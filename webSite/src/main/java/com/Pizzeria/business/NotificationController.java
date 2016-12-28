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
import com.Pizzeria.services.NotificationService;

@Controller
public class NotificationController {
	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private JavaMailSender mailSenders;
	@Autowired
	private Services service;
	
	
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
				infos = factureConstruct(u);
			break;
		default:
			System.out.println("Type_Alert_Introuvable");
			break;
		}
		if(u.getTypeAlert() == TypeNotification.Facture){
			System.out.println("------>Facture");
			envoiMail("test_pds@hotmail.com", "test_pds@hotmail.com", infos);
		}
		template.convertAndSend("/topic/notification", new NotificationService(u.getUserName() + ',' + u.getNotificationDescription()));
		return "sample";
	}

	public void envoiMail(String to, String from, String infos) throws MessagingException {
		MimeMessage mimeMessage = mailSenders.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		String messagetoAdmin = infos;
		mimeMessage.setContent(messagetoAdmin, "text/html");
		helper.setTo(to);
		helper.setSubject("Karco reservation Facture");
		helper.setFrom(from);
		mailSenders.send(mimeMessage);

	}
	
	private String factureConstruct(Notification notif){
		
		return "<div style='margin-left: 500px'>"
	    + "<h1>Karco Reservation Facture!</h1>"
	    + "<table>"
		+ "<tr><td><h3>Paiment</h3></td></tr>"
		+ "<tr><td><h3>ven 21 oct 2016 à 17:35</h3></td></tr>"
		+ "<tr><td>===================================</td></tr>"
		+ "<tr><td>site: </td></tr>"
		+ "<tr><td>===================================</td></tr>"
		+ "<tr><td>TicketPaiment</td></tr>"
		+ "<tr><td>Montant: 27.48 Euro</td></tr>"
		+ "<tr><td>===================================</td></tr>"
		+ "<tr><td>Ticket a Conserver</td></tr>"
		+ "<tr><td>BON VOYAGE <h4>:)</h4></td></tr>"
		+ "<tr><td>===================================</td></tr>"
		+ "<tr><td>Quantité: 1 voyageur</td></tr>"
		+ "<tr><td>REF: abcd</td></tr>"
		+ "<tr><td>==================================</td></tr>"
		+ "<tr><td>Trajet:paris / Liege</td></tr>"
		+ "<tr><td>==================================</td></tr>"
		+ "<tr><td>Date: ven 21 oct 2016 à 17:35</td></tr>"
		+ "<tr><td>==================================</td></tr>"
		+ "<tr><td>PU: 23Euro</td></tr>"
		+ "<tr><td>Frais de Reservation: 4.48 Euro</td></tr>"
		+ "<tr><td>dont TVA: 0.75 Euro</td></tr>"
		+ "</table>"
		+ "</div>";
		
	}
	
	
	
	
	
	
	/*////////////////////////////////////////////////*/
	
	
	
	
	@RequestMapping(value = "addCandidature", method = RequestMethod.POST)
	public String addCandidature(@ModelAttribute Candidature d) throws MessagingException {
		service.add(d);
		envoiMailCandidat(d.getEmail(), "Pizzeria_Win_Win@hotmail.com", d);
		envoiMailAdmin("sema_ma@hotmail.fr", "Pizzeria_Win_Win@hotmail.com", d);
		
		return "RepCandidature";
	}
	
	
	public void envoiMailAdmin(String to, String from, Candidature d) throws MessagingException{
		MimeMessage mimeMessage = mailSenders.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		String messagetoAdmin = "<h1 style='color:#8A2BE2;'>Pizzeria Win-Win!</h1> "
				+ "<h3>Bonjour,<br/><br/>" 
						+ d.getCivilite() + " " + d.getNom() + " " +  d.getPrenom()  
							+ " vient de postuler pour un poste de " + d.getPoste() + "</h3>";
		mimeMessage.setContent(messagetoAdmin, "text/html");
		helper.setTo(to);
		helper.setSubject("Candidature " + d.getPoste());
		helper.setFrom(from);
		mailSenders.send(mimeMessage);
		
	}
	
	
	public void envoiMailCandidat(String to, String from, Candidature d) throws MessagingException{
		MimeMessage mimeMessage = mailSenders.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		String MessagetoCandidat = "<h1 style='color:#8A2BE2;'>Pizzeria Win-Win!</h1> "
							+ "<h3>Bonjour, " 
							+ d.getCivilite() + " " + d.getNom() + " " +  d.getPrenom()  
							+ " Merci pour votre candidature pour le poste " + d.getPoste() 
							+ " votre candidature a été transmis au responsable" 
							+ " de recrutement qui va vous repondre dans les brefs delais</h3>"
							+ "  Très Cordialement.";
		mimeMessage.setContent(MessagetoCandidat, "text/html");
		helper.setTo(to);
		helper.setSubject("Candidature " + d.getPoste());
		helper.setFrom(from);
		mailSenders.send(mimeMessage);
	}
	
	
//	@RequestMapping(value="sendEmail", method=RequestMethod.POST)
//	public String doSendEmail(HttpServletRequest request) throws MessagingException{
		 // takes input from e-mail form
//        String recipientAddress = request.getParameter("recipient");
//        String subject = request.getParameter("subject");
//        String message = request.getParameter("message");
         
//        envoiMail(recipientAddress,subject, message);
//        envoiMailHTML(); 
//		return "sendEMail";
//	}
	
//	public void envoiMail(String recipientAddress, String subject, String message) throws MessagingException{
//		 SimpleMailMessage email = new SimpleMailMessage();
//	        email.setFrom("Pizzeria_Win_Win@hotmail.com");
//	        email.setTo(recipientAddress);
//	        email.setSubject(subject);
//	        email.setText(message);
//	        mailSender.send(email);
//	}
	
//	public void envoiMailMu(String[] recipientAddress, String subject, String message) throws MessagingException{
//		 SimpleMailMessage email = new SimpleMailMessage();
//	        email.setFrom("Pizzeria_Win_Win@hotmail.com");
//	        email.setTo(recipientAddress);
//	        email.setSubject(subject);
//	        email.setText(message);
//	        mailSender.send(email);
//	}
	
}

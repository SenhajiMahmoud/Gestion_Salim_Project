package com.Pizzeria.Methods;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.Pizzeria.Dto.CandidatureDto;
import com.Pizzeria.Dto.NotificationDto;

/**
 * @author Mahmoud
 *
 */
@Service
public class BnsinessMethodsImpl implements BusinessMethods {
	
	@Autowired
	private JavaMailSender mailSenders;
	
	@Override
	public void envoiMailAdmin(String to, String from, CandidatureDto d) {
		MimeMessage mimeMessage = mailSenders.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		
			String messagetoAdmin = "<h1 style='color:#8A2BE2;'>Pizzeria Win-Win!</h1> "
				+ "<h3>Bonjour,<br/><br/>" 
						+ d.getCivilite() /*+ " " + d.getNom() + " " +  d.getPrenom()*/  
							+ " vient de postuler pour un poste de " + d.getPoste() + "</h3>";
			mimeMessage.setContent(messagetoAdmin, "text/html");
			helper.setTo(to);
			helper.setSubject("Candidature " + d.getPoste());
			helper.setFrom(from);
			mailSenders.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String factureConstruct(NotificationDto notif) {
		return "<div>"
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

	@Override
	public void envoiMailCandidat(String to, String from, CandidatureDto d) {
		MimeMessage mimeMessage = mailSenders.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			
			String MessagetoCandidat = "<h1 style='color:#8A2BE2;'>Pizzeria Win-Win!</h1> "
								+ "<h3>Bonjour, " 
								+ d.getCivilite()/* + " " + d.getNom() + " " +  d.getPrenom()  */
								+ " Merci pour votre candidature pour le poste " + d.getPoste() 
								+ " votre candidature a été transmis au responsable" 
								+ " de recrutement qui va vous repondre dans les brefs delais</h3>"
								+ "  Très Cordialement.";
			mimeMessage.setContent(MessagetoCandidat, "text/html");
			helper.setTo(to);
			helper.setSubject("Candidature " + d.getPoste());
			helper.setFrom(from);
			mailSenders.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void envoiMail(String to, String from, String infos) {
		MimeMessage mimeMessage = mailSenders.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			
			String messagetoAdmin = infos;
			mimeMessage.setContent(messagetoAdmin, "text/html");
			helper.setTo(to);
			helper.setSubject("Karco reservation Facture");
			helper.setFrom(from);
			mailSenders.send(mimeMessage);
		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}

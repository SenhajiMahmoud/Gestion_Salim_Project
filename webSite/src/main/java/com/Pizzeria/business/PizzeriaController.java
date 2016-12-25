package com.Pizzeria.business;


import java.security.Principal;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Pizzeria.dao.Services;
import com.Pizzeria.models.Candidature;
import com.Pizzeria.models.Notification;
import com.Pizzeria.services.NotificationService;



/**
 * @author Mahmoud
 *
 */
@Controller
public class PizzeriaController {

	@Autowired
	private Services service;
//	private List<Candidature> ListCand;
//	@Autowired
//	private MailSender mailSender;
	@Autowired
	private JavaMailSender mailSenders;

	
	
	@RequestMapping(value = "/connexionPage", method = RequestMethod.GET)
	public String connexionPage() {
		return "login";
	}
	
	@RequestMapping(value = "/candidature")
	public String Candida() {
		return "candidature";
	}
	
	@RequestMapping(value = "/agenda")
	public String redAgenda() {
		return "agenda";
	}
	
	@RequestMapping(value = "/decNotif")
	public String notif() {
		return "decNotif";
	}

	@RequestMapping(value = "/envNotif")
	public String envnotif() {
		
		System.out.println("envoiNotif");
		
		return "agenda";
	}

	@RequestMapping(value = "/Mail")
	public String mailPage() {
		return "sendEMail";
	}

	@RequestMapping(value = "/Contact")
	public String contact() {
		return "Contact";
	}
	
	@RequestMapping(value = "/apropos")
	public String apropos() {
		return "apropos";
	}
	
	@RequestMapping(value = "/menu")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping(value = "/Galerie")
	public String Galerie() {
		return "Galerie";
	}
	
	@RequestMapping(value = "/Offres")
	public String Offres() {
		return "Offres";
	}
	
	@RequestMapping(value = "/intranet")	
	public String intranet() {
		return "intranet";
	}
	
	@RequestMapping(value = "/testButton")
	public String testButton() {
		return "testButton";
	}
	
	@RequestMapping(value = "/welcome**", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(  @RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView AccessDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}
		
		model.setViewName("403");
		return model;
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
	
	@RequestMapping(value = "addCandidature", method = RequestMethod.POST)
	public String addCandidature(@ModelAttribute Candidature d) throws MessagingException {
		service.add(d);
		envoiMailCandidat(d.getEmail(), "Pizzeria_Win_Win@hotmail.com", d);
		envoiMailAdmin("sema_ma@hotmail.fr", "Pizzeria_Win_Win@hotmail.com", d);
		
		return "RepCandidature";
	}
	
	
//	@RequestMapping(value = "ListCandidature")
//	public ModelAndView List(@ModelAttribute Candidature d) {
//		
//		ModelAndView model = new ModelAndView("rep");
//		ListCand = service.list();
//		model.addObject("list", ListCand);
//		return model;
//		
//	}
	
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
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	public String save(@RequestParam(value="cv") MultipartFile cv
//															, @RequestParam(value="lettre") MultipartFile lettre, Model model
//															, Exception exception) throws IOException{
//		
//		File fCV = null;
//		File fLettre = null;
//		StringBuffer uploadedfile;
//		String cvNom;
//		String LettreNom;
//		String extensionOfFileNameCV;
//		String extensionOfFileNameLettre;
//		FileOutputStream foutCV = null;
//		FileOutputStream foutLettre = null;
//		
//		
//		uploadedfile = new StringBuffer("");
//		String error = "";
//		
//		if(exception instanceof MaxUploadSizeExceededException){
//			error = "taille max doit etre inf a 40 Ko";
//			
//			System.out.println(error);
//			return "helloWorld";
//		}
//		
//		if(cv.isEmpty() && !lettre.isEmpty()){
//			uploadedfile = new StringBuffer("<br/>cv Vide");
//		}else if(lettre.isEmpty() && !cv.isEmpty()){
//			uploadedfile = new StringBuffer("<br/>Lettre de motivation vide");
//		}else if(lettre.isEmpty() && cv.isEmpty()){
//			uploadedfile = new StringBuffer("<br/>Please select file to upload");
//		}else{
//			uploadedfile = new StringBuffer("ok");
//			cvNom = cv.getOriginalFilename();
//			LettreNom = lettre.getOriginalFilename();
//			
//			uploadedfile = new StringBuffer(cvNom + " " + "<br/>" + LettreNom);
//			
//			extensionOfFileNameCV = cvNom.substring(cvNom.indexOf(".") + 1, cvNom.length());
//			extensionOfFileNameLettre = LettreNom.substring(LettreNom.indexOf(".") + 1, LettreNom.length());
//			if(extensionOfFileNameCV.equalsIgnoreCase("pdf") || extensionOfFileNameCV.equalsIgnoreCase("docx") &&
//					extensionOfFileNameLettre.equalsIgnoreCase("pdf") || extensionOfFileNameLettre.equalsIgnoreCase("docx")
//					){
//				uploadedfile.append("<br/>extensionOK" +  " <br/> " + extensionOfFileNameCV + "  " + extensionOfFileNameLettre);
//				
//				fCV = new File("D:\\pdf\\" + cvNom);
//				fLettre = new File("D:\\pdf\\" + LettreNom);
//				
//				try {
//					
//					foutCV = new FileOutputStream(fCV);
//					InputStream inputStream = cv.getInputStream();
//					
//					IOUtils.copy(inputStream, foutCV);
//					
//					foutLettre = new FileOutputStream(fLettre);
//					InputStream inputStream2 = cv.getInputStream();
//					IOUtils.copy(inputStream2, foutLettre);
//				} catch (Exception e) {
//					System.out.println("Error");
//				}finally {
//					foutCV.close();
//					foutLettre.close();
//				}
//			}else{
//				uploadedfile.append("<br/>l'extension des fichiers choisi n'est pas approprié"
//						 + " <br/> "+ extensionOfFileNameCV + "  " + extensionOfFileNameLettre);
//			}
//		}
//		
//		model.addAttribute("message", uploadedfile);
//		return "Upload";
//	}
	
}

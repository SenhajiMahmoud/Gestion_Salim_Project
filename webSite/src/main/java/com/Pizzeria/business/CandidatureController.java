package com.Pizzeria.business;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Pizzeria.models.Candidature;
import com.Pizzeria.services.BusinessMethods;

/**
 * @author Mahmoud
 *
 */
@Controller
public class CandidatureController {
	@Autowired
	private BusinessMethods BMethods;

	@RequestMapping(value = "addCandidature", method = RequestMethod.POST)
	public String addCandidature(@ModelAttribute Candidature candidature) throws MessagingException {
		System.out.println("Candidature");
		// service.add(candidature);
		BMethods.envoiMailCandidat("sema_ma@hotmail.fr"/* candidature.getEmail() */, "Pizzeria_Win_Win@hotmail.com", candidature);
		BMethods.envoiMailAdmin("sema_ma@hotmail.fr", "Pizzeria_Win_Win@hotmail.com", candidature);

		return "redirect:/addC.do";
	}

	@RequestMapping(value = "addC", method = RequestMethod.GET)
	public String handleGetRequest() {
		return "RepCandidature";
	}
}

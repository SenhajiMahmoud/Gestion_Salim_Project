package com.Pizzeria.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Pizzeria.services.Services;


/**
 * @author Mahmoud
 *
 */
@Controller
public class EventController {

	@Autowired
	private Services service;

	@RequestMapping(value = "/dd")
	public void getEvents() {

		System.out.println("ok");
		
	}

}

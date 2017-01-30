package com.Pizzeria.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Pizzeria.service.PizzeriaServices;


/**
 * @author Mahmoud
 *
 */
@Controller
public class EventController {

//	@Autowired
//	private PizzeriaServices service;

	@RequestMapping(value = "/dd")
	public void getEvents() {

		System.out.println("ok");
		
	}

}

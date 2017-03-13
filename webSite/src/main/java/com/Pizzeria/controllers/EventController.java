package com.Pizzeria.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Pizzeria.Dto.EventDto;
import com.Pizzeria.service.PizzeriaServices;


/**
 * @author Mahmoud
 *
 */
@Controller
@RequestMapping("/events/")
public class EventController {

	@Autowired
	private PizzeriaServices service;

	@RequestMapping(value = "/dd/{uId}", method = RequestMethod.GET)
	@ResponseBody
	public String getEvents(@PathVariable("uId") int id) {
		String s=service.listEvent(id);
		System.out.println(s);
		System.out.println("ok --> " + " " + id);
		return s;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addEvents(@RequestBody EventDto event) {
		service.addEvent(event);
	}

}

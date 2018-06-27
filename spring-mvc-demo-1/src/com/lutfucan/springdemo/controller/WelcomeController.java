package com.lutfucan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lutfucan.springdemo.service.GenericWelcomeService;

@Controller
public class WelcomeController {
	
	@Autowired
	private GenericWelcomeService welcomeService;

	@RequestMapping("/")
	public String doWelcome(Model model) {

		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Mehmet Lutfu");
		
		model.addAttribute("myWelcomeMessage", welcomeMessage);
		
		return "welcomeNew";
	}
}

package com.domainlist.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DLController {

	@RequestMapping("/")
	public String homePage(ModelMap model) {
		model.addAttribute("deger", "Selamlama");
		return "home";
	}
}

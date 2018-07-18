package com.lutfucan.domainlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lutfucan.domainlist.domain.Domains;
import com.lutfucan.domainlist.service.DomainService;

@Controller
public class DomainController {

	@Autowired
	private DomainService domainService;
	
	@RequestMapping("/list")
	public String listOrganizationUsingService(Model model) {
		List<Domains> orgs = domainService.getOrgList();
		model.addAttribute("orgList", orgs);
		return "domainList";
	}
}

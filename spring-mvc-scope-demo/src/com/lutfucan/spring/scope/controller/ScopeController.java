package com.lutfucan.spring.scope.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lutfucan.spring.scope.service.RequestScopeService;
import com.lutfucan.spring.scope.service.SessionScopeService;

@Controller
public class ScopeController {
	
	@Autowired
	RequestScopeService requestScopeService;
	
	@Autowired
	SessionScopeService sessionScopeService;
	
	@RequestMapping("/")
	public void getWriter(HttpServletResponse response) throws Exception{
		response.getWriter().write("************** request scope **************<br>");
		response.getWriter().write("Ýlk sayý : " + requestScopeService.getRandomNumber() + "<br>");
		requestScopeService.generateRandomNumber();
		response.getWriter().write("Son sayý : " + requestScopeService.getRandomNumber() + "<br>");
		response.getWriter().write("Referans : " + requestScopeService.toString() + "<br>");
		
		response.getWriter().write("************** session scope **************" + "<br>");
		response.getWriter().write("Ýlk sayý : " + sessionScopeService.getRandomNumber() + "<br>");
		sessionScopeService.generateRandomNumber();
		response.getWriter().write("Son sayý : " + sessionScopeService.getRandomNumber() + "<br>");
		response.getWriter().write("Referans : " + sessionScopeService.toString());
	}
	

}

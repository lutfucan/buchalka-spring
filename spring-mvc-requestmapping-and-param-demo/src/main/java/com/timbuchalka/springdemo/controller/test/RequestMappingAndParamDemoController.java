package com.timbuchalka.springdemo.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);
	
	@RequestMapping(value="/home")
	public String home() {
		return "requestMappingAndParamHome";
	}
	
	@RequestMapping(value="/test1")
	public String test1(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value="/test2", method = RequestMethod.GET)
	public String test2(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value="*", method = RequestMethod.GET)
	public String test3() {
		return "fallback";
	}
	
	@RequestMapping(value="/test4")
	public String test4(@RequestParam( value = "orgname", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value="/test5", method = RequestMethod.GET)
	public String test5(@RequestParam String orgName, Model model) {
		model.addAttribute("testserial", "test5");
		return "requestMappingAndParamResults";
	}
	
	//Bundan sonrasý http://localhost:8080/spring-mvc-requestmapping-and-param-demo/requestMappingAndParamDemo/test6
	//adresinden itibaren manuel parametrelerle çalýþtýrýlacak testler.
	
	@RequestMapping(value="/test6", params="orgname")
	public String test6v1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6v1");
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value="/test6", params="empcount")
	public String test6v2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6v2");
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value="/test6/subtest3", method = RequestMethod.GET, params= {"orgname","empcount"})
	public String test6v3(@RequestParam String orgname, @RequestParam String empcount,Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("empcount", empcount);
		model.addAttribute("testserial", "test6v3");
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value="/test6/subtest4", method = RequestMethod.GET, params= {"orgname","empcount"})
	public String test6v4(@RequestParam String orgname, @RequestParam String empcount,Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6v4");
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value= {"test7", "test8"}, method = RequestMethod.GET)
	public String test7and8(@RequestParam String orgname, Model model, HttpServletRequest request) {
		model.addAttribute("orgname", orgname);
		LOGGER.info(request.getRequestURL().toString());
		if(request.getRequestURL().toString().contains("test7")) {
			model.addAttribute("testserial", "test7");
		}else {
			model.addAttribute("testserial", "test8");

		}
		return "requestMappingAndParamResults2";
	}
	
}

package com.lutfucan.domainlist.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


//Web.xml dosyas�n�n yerine java based configuration i�in kullan�lacak s�n�ft�r.

public class WebMvcInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic registeration = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
		registeration.addMapping("/");
		registeration.setLoadOnStartup(1);
	}

}

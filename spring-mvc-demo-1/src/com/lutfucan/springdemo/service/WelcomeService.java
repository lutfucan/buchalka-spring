package com.lutfucan.springdemo.service;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService implements GenericWelcomeService {
	
	@Override
	public List<String> getWelcomeMessage(String name) {
		List<String> myWelcomeMessage = new ArrayList<>();
		
		// Add data to the list
		myWelcomeMessage.add("Merhaba! ");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", Spring eðitimine hoþgeldiniz :-)");
		
		return myWelcomeMessage;
	}

}

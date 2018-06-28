package com.lutfucan.spring.scope.service;

public class SessionScopeService {
	public int randomNumber = 10;

	public int getRandomNumber() {
		return randomNumber;
	}
	
	public void generateRandomNumber() {
		randomNumber = (int) (Math.random() * 99999);
	}

}

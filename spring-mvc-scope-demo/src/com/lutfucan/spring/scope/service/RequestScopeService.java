package com.lutfucan.spring.scope.service;

public class RequestScopeService {
	public int randomNumber = 5;

	public int getRandomNumber() {
		return randomNumber;
	}
	
	public void generateRandomNumber() {
		randomNumber = (int) (Math.random() * 99999);
	}

}

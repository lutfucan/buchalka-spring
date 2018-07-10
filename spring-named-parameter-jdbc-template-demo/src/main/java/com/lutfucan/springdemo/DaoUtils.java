package com.lutfucan.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lutfucan.springdemo.dao.OrganizationDao;
import com.lutfucan.springdemo.domain.Organization;

@Service //@Component'in bir baþka özelleþtrilmiþ hali
public class DaoUtils {

	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";
	
	public void printOrganizations (List<Organization> orgs, String operation) {
		System.out.println("\n*******printing organizations after " + operation + " operation *********");
		for(Organization org : orgs) {
			System.out.println(org);
		}
	}
	
	public void printOrganization (Organization org, String operation) {
		System.out.println("\n*******printing organization after " + operation + " operation *********");
		System.out.println(org);
	}
	
	public void printSuccessFailure(String operation, boolean param) {
		if(param)
			System.out.println("\nOperation " + operation + " successful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}
	
	public void createSeedData(OrganizationDao dao) {
		Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
		Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate driving machines");
		Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");
		
		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(0, org1);
		orgs.add(1, org2);
		orgs.add(2, org3);
		int createCount = 0;
		
		for(Organization org : orgs) {
			boolean isCreated = dao.create(org);
			if(isCreated)
				createCount++;
		}
		System.out.println("Created " + createCount + " organizations");
	}
	
	public void printOrganizationCount (List<Organization> orgs, String operation) {
		System.out.println("\n******Currently we have " + orgs.size() + " organizations after " 
				+ operation + " operation*****");
		
	}
}

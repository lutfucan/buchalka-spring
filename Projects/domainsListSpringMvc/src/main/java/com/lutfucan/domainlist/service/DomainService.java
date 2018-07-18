package com.lutfucan.domainlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lutfucan.domainlist.dao.DomainDao;
import com.lutfucan.domainlist.domain.Domains;

@Service
public class DomainService {
	
	@Autowired
	private DomainDao domainDao;
	
	public List<Domains> getOrgList() {
		List<Domains> orgList = domainDao.getAllDomains();
		return orgList;
	}
}

package com.lutfucan.domainlist.dao;

import java.util.List;

import javax.sql.DataSource;

import com.lutfucan.domainlist.domain.Domains;

public interface DomainDao {

	public void setDataSource(DataSource ds);

	public boolean create(Domains domain);

	public Domains getDomain(Integer id);

	public List<Domains> getAllDomains();

	public boolean delete(Domains org);
	
	public boolean update(Domains org);
	
	public void cleanup();

}

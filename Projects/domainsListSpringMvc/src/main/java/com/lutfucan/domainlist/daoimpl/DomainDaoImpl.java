package com.lutfucan.domainlist.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.lutfucan.domainlist.dao.DomainDao;
import com.lutfucan.domainlist.domain.Domains;

@Repository
public class DomainDaoImpl implements DomainDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Domains org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "INSERT INTO domain (domain, category, registrar, reg_date, exp_date, cost, min_sale_price, preferred_sale_price, status, comment)"
				+ "VALUES(:domainName, :category, :registrar, :regDate, :expDate, :cost, :minPrice, :prefferedPrice, :status, :comment)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public Domains getDomain(Integer id) {
		SqlParameterSource beanParams = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT id, domain, category, registrar, reg_date, exp_date, cost, min_sale_price, preferred_sale_price, status, comment FROM domain "
				+ "WHERE id=:ID";
		Domains domains = namedParameterJdbcTemplate.queryForObject(sqlQuery, beanParams, new DomainRowMapper());
		return domains;
	}

	public List<Domains> getAllDomains() {
		String sqlQuery = "SELECT * FROM domain";
		List<Domains> domainList = namedParameterJdbcTemplate.query(sqlQuery, new DomainRowMapper());
		return domainList;
	}

	public boolean delete(Domains domains) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(domains);		
		String sqlQuery = "DELETE FROM domain WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Domains domain) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(domain);		
		String sqlQuery = "UPDATE domain SET min_sale_price = :minPrice WHERE id= :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE domain ";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}

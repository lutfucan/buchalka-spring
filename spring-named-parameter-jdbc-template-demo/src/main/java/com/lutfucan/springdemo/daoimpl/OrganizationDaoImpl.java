package com.lutfucan.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.lutfucan.springdemo.dao.OrganizationDao;
import com.lutfucan.springdemo.domain.Organization;

//Bu bean'in annotation yoluyla scan edilmesini istediðimiz için @Component muadili olan
//@Repository yi kullanýyoruz. Ancak xml içinde bean property'lerini vermediðimiz için
//ref yerine burada @Autowired kullanýyoruz
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org); //org beaninin parametrelerini sql e aktar
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan)"
				+ "VALUES(:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public Organization getOrganization(Integer id) {
		SqlParameterSource beanParams = new MapSqlParameterSource("ID", id);//bean'e ait bir alaný sql parametresine ata
		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan FROM organization "
				+ "WHERE id=:ID";
		Organization org = namedParameterJdbcTemplate.queryForObject(sqlQuery, beanParams, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = namedParameterJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);		
		String sqlQuery = "DELETE FROM organization WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);		
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id= :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization ";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery); //JDBC iþlemlerine get metodlarý ile eriþebiliyoruz
	}

}

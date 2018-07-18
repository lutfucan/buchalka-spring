package com.lutfucan.domainlist.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lutfucan.domainlist.domain.Domains;

public class DomainRowMapper implements RowMapper<Domains>{

	public Domains mapRow(ResultSet rs, int rownum) throws SQLException {
		Domains domain = new Domains();
		domain.setId(rs.getInt("id"));
		domain.setDomainName(rs.getString("domain"));
		domain.setCategory(rs.getString("category"));
		domain.setRegistrar(rs.getString("registrar"));
		domain.setRegDate(rs.getDate("reg_date"));
		domain.setExpDate(rs.getDate("exp_date"));
		domain.setCost(rs.getDouble("cost"));
		domain.setMinPrice(rs.getDouble("min_sale_price"));
		domain.setPrefferedPrice(rs.getDouble("preferred_sale_price"));
		domain.setStatus(rs.getString("status"));
		domain.setComment(rs.getString("comment"));
		
		return domain;
	}

}

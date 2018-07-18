package com.lutfucan.domainlist.domain;

import java.sql.Date;

public class Domains {

	private int id;
	private String domainName;
	private String registrar;
	private String category;
	private Date regDate;
	private Date expDate;
	private double cost;
	private double minPrice;
	private double prefferedPrice;
	private String status;
	private String comment;

	public Domains(String domainName, String registrar, String category, Date regDate, Date expDate, double cost,
			double minPrice, double prefferedPrice, String status, String comment) {
		this.domainName = domainName;
		this.registrar = registrar;
		this.category = category;
		this.regDate = regDate;
		this.expDate = expDate;
		this.cost = cost;
		this.minPrice = minPrice;
		this.prefferedPrice = prefferedPrice;
		this.status = status;
		this.comment = comment;
	}

	public Domains() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getRegistrar() {
		return registrar;
	}

	public void setRegistrar(String registrar) {
		this.registrar = registrar;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getPrefferedPrice() {
		return prefferedPrice;
	}

	public void setPrefferedPrice(double prefferedPrice) {
		this.prefferedPrice = prefferedPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Domains [domainName=" + domainName + ", registrar=" + registrar + ", category=" + category
				+ ", regDate=" + regDate + ", expDate=" + expDate + ", cost=" + cost + ", minPrice=" + minPrice
				+ ", prefferedPrice=" + prefferedPrice + ", status=" + status + ", comment=" + comment + "]";
	}
}

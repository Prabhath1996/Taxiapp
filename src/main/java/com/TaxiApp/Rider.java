package com.TaxiApp;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.xml.crypto.Data;


public class Rider {
	
	private int id;
	private String name;
	private Timestamp joined_date;
	private String gender;
	private String country;
	private String phone_no;
	private Date dob;
	private String current_payment_type;
	private String current_payement_ac;
	
	
	
	public Rider() {
		super();
	}


	public Rider(int id, String name, Timestamp joined_date, String gender, String country, String phone_no, Date dob,
			String current_payment_type, String current_payement_ac) {
		super();
		this.id = id;
		this.name = name;
		this.joined_date = joined_date;
		this.gender = gender;
		this.country = country;
		this.phone_no = phone_no;
		this.dob = dob;
		this.current_payment_type = current_payment_type;
		this.current_payement_ac = current_payement_ac;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timestamp getJoined_date() {
		return joined_date;
	}


	public void setJoined_date(Timestamp joined_date) {
		this.joined_date = joined_date;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getCurrent_payment_type() {
		return current_payment_type;
	}


	public void setCurrent_payment_type(String current_payment_type) {
		this.current_payment_type = current_payment_type;
	}


	public String getCurrent_payement_ac() {
		return current_payement_ac;
	}


	public void setCurrent_payement_ac(String current_payement_ac) {
		this.current_payement_ac = current_payement_ac;
	}


	
	
	
	
	
	

}

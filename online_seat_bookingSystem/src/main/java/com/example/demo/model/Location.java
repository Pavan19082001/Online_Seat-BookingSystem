package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;
	private String name;
	private String country;
	private String code;
	@OneToOne(cascade=CascadeType.ALL)
	private OfficeDetails office;
	
	public Location() {}

	public int getId() {
		return locationId;
	}

	public void setId(int id) {
		this.locationId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public OfficeDetails getOffice() {
		return office;
	}

	public void setOffice(OfficeDetails office) {
		this.office = office;
	}
	
}

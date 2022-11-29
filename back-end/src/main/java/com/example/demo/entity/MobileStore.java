package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "MobileStore")
public class MobileStore {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name = "modelname")
	@NotBlank(message = "Name of the phone cannot be blank.")
	@NotNull(message = "Name of the phone cannot be null.")
	private String modelname;
	
	@Column(name="company")
	@NotBlank(message = "Company name cannot be Blank.")
	@NotNull(message = "Company name cannot be Null.")
	private String company;
	
	@Column(name = "flagshipphone")
	private boolean flagshipphone;
	
	@Column(name = "price")
	@Positive(message = "Price of the phone cannot be Zero Or Negative.")
	private Integer price;
	
	@Column(name = "warranty")
	@PositiveOrZero(message = "Warranty of the Phone cannot be Negative.")
	private Integer warranty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelName(String modelname) {
		this.modelname = modelname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean isFlagshipphone() {
		return flagshipphone;
	}

	public void setFlagshipphone(boolean flagshipphone) {
		this.flagshipphone = flagshipphone;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getWarranty() {
		return warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}
}

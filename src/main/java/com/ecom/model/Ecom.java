package com.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ecom")
@Table(name = "ecom")
public class Ecom {

	@Id
	@GeneratedValue
	
	@Column(name ="id")
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="quantity")
	private int quantity;
	
	@Column(name ="price")
	private  Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}

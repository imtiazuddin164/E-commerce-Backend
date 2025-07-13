package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "orderItems")
@Table(name = "orderItems")
public class OrderItems {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary Key

    private String name;
    private int quantity;
    private double price;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")  // Foreign Key
//    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;
    
 // Getters and Setters
    
//	private String createdByCode;
//	private String createdByName;
//	private String createdAt;
//	
//	
//	private String updatedByCode;
//	private String updatedByName;
//	private String updatedAt;
    
    

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	@Column(name = "orderItems_code")
//	private int orderItemsCode;
//	
//	@Column(name = "orderDetails_id")
//	private int orderDetailsId;
//	
//	@Column(name = "product_id")
//	private int productId;
//	
//	@Column(name = "quantity")
//	private int quantity;
//	
//	@Column(name = "price")
//	private int price;
//	
//	@Column(name = "createdBy_code")
//	private String createdByCode;
//	
//	@Column(name = "createdBy_name")
//	private String createdByName;
//	
//	@Column(name = "created_at")
//	private Date createdAt;
//	
//	
//	@Column(name = "updatedBy_code")
//	private String updatedByCode;
//	
//	@Column(name = "updatedBy_name")
//	private String updatedByName;
//	
//	@Column(name = "updated_at")
//	private Date  updatedAt;

}

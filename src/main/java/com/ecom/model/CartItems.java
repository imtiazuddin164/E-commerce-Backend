package com.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "cartItems")
@Table(name = "cartItems")
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "cartItems_code")
	private int cartItemsCode;
	
	@Column(name = "user_id")
	private int userId;

	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private int price;

	@Column(name = "total_price")
	private int totalPrice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCartItemsCode() {
		return cartItemsCode;
	}

	public void setCartItemsCode(int cartItemsCode) {
		this.cartItemsCode = cartItemsCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	


	
	
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
//	private Date updatedAt;
	
	

	

}

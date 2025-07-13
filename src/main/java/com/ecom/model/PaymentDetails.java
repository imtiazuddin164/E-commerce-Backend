package com.ecom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "paymentDetails")
@Table(name = "paymentDetails")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "paymentDetails_code")
	private int paymentDetailsCode;

	@Column(name = "order_id")
	private int orderId;

	@Column(name = "paymentMethod_id")
	private int paymentMethodId;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "payment_status")
	private int paymentStatus;

	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "createdBy_code")
	private String createdByCode;
	
	@Column(name = "createdBy_name")
	private String createdByName;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	
	@Column(name = "updatedBy_code")
	private String updatedByCode;
	
	@Column(name = "updatedBy_name")
	private String updatedByName;
	
	@Column(name = "updated_at")
	private Date  updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPaymentDetailsCode() {
		return paymentDetailsCode;
	}

	public void setPaymentDetailsCode(int paymentDetailsCode) {
		this.paymentDetailsCode = paymentDetailsCode;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getCreatedByCode() {
		return createdByCode;
	}

	public void setCreatedByCode(String createdByCode) {
		this.createdByCode = createdByCode;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedByCode() {
		return updatedByCode;
	}

	public void setUpdatedByCode(String updatedByCode) {
		this.updatedByCode = updatedByCode;
	}

	public String getUpdatedByName() {
		return updatedByName;
	}

	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}

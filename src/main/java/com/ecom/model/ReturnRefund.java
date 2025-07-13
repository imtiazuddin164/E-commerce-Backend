package com.ecom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "returnRefund")
@Table(name = "returnRefund")
public class ReturnRefund {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "returnRefund_code")
	private int returnRefundCode;
	
	@Column(name = "orderItems_id")
	private String orderItemsId;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "refund_amt")
	private String refundAmt;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getReturnRefundCode() {
		return returnRefundCode;
	}

	public void setReturnRefundCode(int returnRefundCode) {
		this.returnRefundCode = returnRefundCode;
	}

	public String getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(String orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefundAmt() {
		return refundAmt;
	}

	public void setRefundAmt(String refundAmt) {
		this.refundAmt = refundAmt;
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

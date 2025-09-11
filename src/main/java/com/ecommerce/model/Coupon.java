package com.ecommerce.model;

import com.ecommerce.enums.Cpon;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "coupon")
@Table(name = "coupon")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "coupon_code")
	private String couponCode;
	
	@Column(name = "discount_amount")
	private int discountAmount;
	
    @Enumerated(EnumType.STRING)
    private Cpon type;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Cpon getType() {
		return type;
	}

	public void setType(Cpon type) {
		this.type = type;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
//	private Date  updatedAt;

	
}

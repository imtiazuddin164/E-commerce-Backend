package com.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "deliveryInformation")
@Table(name = "deliveryInformation")
public class DeliveryInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "deliveryInformation_code")
	private int deliveryDetailsCode;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "delivery_date")
	private int deliveryDate;
	
	@Column(name = "tracking_number")
	private int trackingNumber;
	
	@Column(name = "courier_service")
	private int courierService;
	
	
	
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

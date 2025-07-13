package com.ecom.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ecom.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "orders")
@Table(name = "orders")
public class Order {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id;

    private String orderCode;
    private Date date;
    private String customerName;
    private String phone;
    private String paymentMethod;
    private String mobileType;
    private String address;
    private double subtotal;
    private double vat;
    private double deliveryFee;
    private double total;
    private boolean approved = false; // Admin approval status
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItems> items;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<OrderItems> items;

    
    public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


    public void setItems(List<OrderItems> items) {
        this.items = items;
        if (items != null) {
            for (OrderItems item : items) {
                item.setOrder(this);  // Set back-reference
            }
        }
    }
    
    
//    public void setItems(List<OrderItem> items) {
//        this.items = items;
//        if (items != null) {
//            for (OrderItem item : items) {
//                item.setOrder(this); // 🔁 Link child to parent
//            }
//        }
//    }

    
    
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

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getMobileType() {
		return mobileType;
	}

	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<OrderItems> getItems() {
		return items;
	}

    
//	@Column(name = "user_id")
//	private int userId;
//	@Column(name = "order_code")
//	private String orderCode;
//	@Column(name = "customer_name")
//	private int customerName;
//	@Column(name = "phone")
//	private int phone;
//	@Column(name = "address")
//	private int address;
//	@Column(name = "total_amount")
//	private int totalAmount;
//	@Column(name = "order_date")
//	private int orderDate;
//	@Column(name = "status")
//	private int status;
//		
}

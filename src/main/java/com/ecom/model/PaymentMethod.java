package com.ecom.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "paymentMethod")
@Table(name = "paymentMethod")
public class PaymentMethod {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "paymentMethod_code")
    private String paymentMethodCode; 
    
    @Column(name = "method_name")
    private String methodName; 

    @Column(name = "method_type")
    private String methodType;

    @Column(name = "provider")
    private String provider;

    @Column(name = "status")
    private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentMethodCode() {
		return paymentMethodCode;
	}

	public void setPaymentMethodCode(String paymentMethodCode) {
		this.paymentMethodCode = paymentMethodCode;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

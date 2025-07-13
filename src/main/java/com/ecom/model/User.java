package com.ecom.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "user")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "u_name")
	private String name; 
	
	@Column(name = "usr_name")
	private String userName;
	
	@Column(name = "e_mail")
	private String email;
	
	@Column(name = "u_phone")
	private int phone;
	
	@Column(name = "u_password")
	private String password; 
	
	@Column(name = "u_confirmpassword")
	private String confirmPassword;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	

	
//	private String createdByCode;
//	private String createdByName;
//	private String createdAt;
//	
//	
//	private String updatedByCode;
//	private String updatedByName;
//	private String updatedAt;

//	
//	  @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//	    private String username;
//	    private String password;
//	    private String email;
//
//	    // Getters and Setters
//	    public Long getId() {
//	        return id;
//	    }
//
//	    public void setId(Long id) {
//	        this.id = id;
//	    }
//
//	    public String getUsername() {
//	        return username;
//	    }
//
//	    public void setUsername(String username) {
//	        this.username = username;
//	    }
//
//	    public String getPassword() {
//	        return password;
//	    }
//
//	    public void setPassword(String password) {
//	        this.password = password;
//	    }
//
//	    public String getEmail() {
//	        return email;
//	    }
//
//	    public void setEmail(String email) {
//	        this.email = email;
//	    }
//	    
//	    
//	    @Id
//		@GeneratedValue(strategy = GenerationType.AUTO)
//		private long id;

//	@Column(name = "user_code")
//	private int userCode;
//
//	@Column(name = "name")
//	private String name;
//
//	@Column(name = "email")
//	private String email;
//
//	@Column(name = "password")
//	private String password;
//
//	@Column(name = "phone")
//	private int phone;
//
//	@Column(name = "dateOf_birth")
//	private Date dateOfBirth;
//
//	@Column(name = "role")
//	private String role;
//
//	@Column(name = "is_seller")
//	private Boolean isSeller;
//
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
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public int getUserCode() {
//		return userCode;
//	}
//
//	public void setUserCode(int userCode) {
//		this.userCode = userCode;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public int getPhone() {
//		return phone;
//	}
//
//	public void setPhone(int phone) {
//		this.phone = phone;
//	}
//
//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}
//
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	public Boolean getIsSeller() {
//		return isSeller;
//	}
//
//	public void setIsSeller(Boolean isSeller) {
//		this.isSeller = isSeller;
//	}
//
//	public String getCreatedByCode() {
//		return createdByCode;
//	}
//
//	public void setCreatedByCode(String createdByCode) {
//		this.createdByCode = createdByCode;
//	}
//
//	public String getCreatedByName() {
//		return createdByName;
//	}
//
//	public void setCreatedByName(String createdByName) {
//		this.createdByName = createdByName;
//	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public String getUpdatedByCode() {
//		return updatedByCode;
//	}
//
//	public void setUpdatedByCode(String updatedByCode) {
//		this.updatedByCode = updatedByCode;
//	}
//
//	public String getUpdatedByName() {
//		return updatedByName;
//	}
//
//	public void setUpdatedByName(String updatedByName) {
//		this.updatedByName = updatedByName;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

}

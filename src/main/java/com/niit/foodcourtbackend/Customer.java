package com.niit.foodcourtbackend;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {

	@Id
	private Integer custId;
	private String firstName;
	private String lastName;
	private String mobile;
	private String username;
	private String password;
	@Transient 
	private String comfirmPassword;
	public Integer getCustId() {
		return this.custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getComfirmPassword() {
		return this.comfirmPassword;
	}
	public void setComfirmPassword(String comfirmPassword) {
		this.comfirmPassword = comfirmPassword;
	}
	
	
}

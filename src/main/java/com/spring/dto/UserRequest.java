package com.spring.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class UserRequest {
	
	private String userName;
	private String userEmail;
	private String userPassword;
	
	@Min(value = 6000000000l,message="should be greater than 6000000000 ")
	@Max(value = 9999999999l,message = "should be less than 999999999")
	private long phoneNo;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	

}

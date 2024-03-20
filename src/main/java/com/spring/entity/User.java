package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users") //because user is a keyWord
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull
	private String userName;
	@Email(regexp = "^(.+)@(\\S+) $.",message = "Email is Invalid")
	private String userEmail;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Password must"
			+ " contain at least one letter, one number, one special character" )
	private String userPassword;
	@Min(value = 6000000000l,message="should be greater than 6000000000 ")
	@Max(value = 9999999999l,message = "should be less than 999999999")
	private long phoneNo;
	
	
	/*
	 * public int getUserId() { return userId; } public void setUserId(int userId) {
	 * this.userId = userId; } public String getUserName() { return userName; }
	 * public void setUserName(String userName) { this.userName = userName; } public
	 * String getUserEmail() { return userEmail; } public void setUserEmail(String
	 * userEmail) { this.userEmail = userEmail; } public String getUserPassword() {
	 * return userPassword; } public void setUserPassword(String userPassword) {
	 * this.userPassword = userPassword; } public long getPhoneNo() { return
	 * phoneNo; } public void setPhoneNo(long phoneNo) { this.phoneNo = phoneNo; }
	 */	
	
}
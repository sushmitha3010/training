package com.model;

public class Deposit {

	//To Declare the Variables
     private Integer userId;
     private String userName;
     private String mobileNo;
     private String accountNo;
     private Integer ifscCode;
     private Integer amount;
	
     //Default Constructor
     public Deposit() {
			
	}

     
     //Parameterized Constructor 
	public Deposit(Integer userId, String userName, String mobileNo, String accountNo, Integer ifscCode,Integer amount) {
		this.userId = userId;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.amount = amount;
	}

	
	
	//To Generate Getters and Setters
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(Integer ifscCode) {
		this.ifscCode = ifscCode;
	}


	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	//To String 
	@Override
	public String toString() {
		return "Deposit [userId=" + userId + ", userName=" + userName + ", mobileNo=" + mobileNo + ", accountNo="
				+ accountNo + ", ifscCode=" + ifscCode + ", amount=" + amount + "]";
	
		
	}

     
    }
	
	

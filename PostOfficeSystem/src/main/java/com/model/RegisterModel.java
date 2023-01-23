package com.model;

public class RegisterModel {

	

    //To Using the Variables
       private String userId;
       private String userName;
       private String password;
       private String mobileNo;
       private String aadharNo;
       private String address;
       
       
      //To Get the Default Constructor
	  public RegisterModel() {
		
	}


	  //To Get the Parameterized Constructor
	  public RegisterModel(String userId, String userName, String password, String mobileNo, String aadharNo, String address) {
			
			this.userId = userId;
			this.userName = userName;
			this.password = password;
			this.mobileNo = mobileNo;
			this.aadharNo = aadharNo;
			this.address = address;
	}

     //Getters and Setters
	 public String getUserId() {
		return userId;
	}


	 public void setUserId(String userId) {
		this.userId = userId;
	}


	 public String getUserName() {
		return userName;
	}


	 public void setUserName(String userName) {
		this.userName = userName;
	}


	 public String getPassword() {
		return password;
	}


	 public void setPassword(String password) {
		this.password = password;
	}


	 public String getMobileNo() {
		return mobileNo;
	}


	 public void setMobileNo(String mobileNo) {
		 this.mobileNo = mobileNo;
	}


	 public String getAadharNo() {
		return aadharNo;
	}


	 public void setAadharNo(String aadharNo) {
		 this.aadharNo = aadharNo;
	}


	 public String getAddress() {
		return address;
	}


	 public void setAddress(String address) {
		this.address = address;
	}

    //To String
	@Override
	 public String toString() {
		return "Register [userId=" + userId + ", userName=" + userName + ", password=" + password + ", mobileNo="
				+ mobileNo + ", aadharNo=" + aadharNo + ", address=" + address + "]";
	}
	
}



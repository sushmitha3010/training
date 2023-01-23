package com.model;

public class Admin {
	private String mailId;
	private String password;

public Admin() {
		
	}
	public Admin(String mailId, String password) {
		super();
		this.mailId = mailId;
		this.password = password;
	}
	
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [mailId=" + mailId + ", password=" + password + "]";
	}

	
}
	

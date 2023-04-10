package com.postoffice.postofficemanagement.model;

public class ForgetPassword {

	private String newPassword;
	private String confirmPassword;
	public ForgetPassword() {
		super();
	
	}
	public ForgetPassword(String newPassword, String confirmPassword) {
		super();
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "ForgetPassword [newPassword=" + newPassword + ", confirmPassword=" + confirmPassword + "]";
	}
	
	
}

package com.model;

public class ParcelBookingType {

	private String userId;
	private String userName;
	private String mobileNo;
	private String fromAddress;
	private String toAddress;
	private String parcelId;
	private String trackingId;
	
	
	public ParcelBookingType() {
		
	}


	public ParcelBookingType(String userId, String userName, String mobileNo, String fromAddress, String toAddress,
			String parcelId, String trackingId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.parcelId = parcelId;
		this.trackingId = trackingId;
	}


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


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getFromAddress() {
		return fromAddress;
	}


	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}


	public String getToAddress() {
		return toAddress;
	}


	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}


	public String getParcelId() {
		return parcelId;
	}


	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}


	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	@Override
	public String toString() {
		return "ParcelBookingType [userId=" + userId + ", userName=" + userName + ", mobileNo=" + mobileNo
				+ ", fromAddress=" + fromAddress + ", toAddress=" + toAddress + ", parcelId=" + parcelId
				+ ", trackingId=" + trackingId + "]";
	}
	
}

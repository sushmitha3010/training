package com.postoffice.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.postoffice.postofficemanagement.model.RegisteredPostModel;

public class RegisteredSearchMapper implements RowMapper<RegisteredPostModel> {

	@Override
	public RegisteredPostModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		RegisteredPostModel registerPost = new RegisteredPostModel();
		
		String senderName = rs.getString("sender_name");
		Long senderMobileNo = rs.getLong("sender_mobile_no");
		String senderAddress = rs.getString("sender_address");
		float parcelWeight = rs.getFloat("parcel_weight");
		String receiverName = rs.getString("receiver_name");
		Long receiverMobileNo = rs.getLong("receiver_mobile_no");
		String receiverAddress = rs.getString("receiver_address");
		Date bookingDate = rs.getDate("booking_date");
		Integer trackingNo = rs.getInt("tracking_no");
		String status = rs.getString("status");

		registerPost.setSendUserName(senderName);
		registerPost.setSendUserMobileNo(senderMobileNo);
		registerPost.setSendUserAddress(senderAddress);
		
		registerPost.setParcelWeight(parcelWeight);
		registerPost.setReceiveUserName(receiverName);
		registerPost.setReceiveUserMobileNo(receiverMobileNo);
		registerPost.setReceiveUserAddress(receiverAddress);
		registerPost.setBookingDate(bookingDate);
		registerPost.setTrackingNo(trackingNo);
		registerPost.setTrackingStatus(status);

		
		return registerPost;
	}


}

package com.postoffice.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.postoffice.postofficemanagement.model.UserModel;

public class ProfileMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserModel register=new UserModel();
		
		String uName=rs.getString("user_name");
		register.setUserName(uName);
		
		String pass=rs.getString("password");
		register.setPassword(pass);
		
		Long mobNo=rs.getLong("mobile_no");
		register.setMobileNo(mobNo);
		
		Long acctNo=rs.getLong("account_no");
		register.setAccountNo(acctNo);
		
		String mail=rs.getString("mail_id");
		register.setMailId(mail);
		
		String address=rs.getString("address");
		register.setAddress(address);
		
		return register;
		
	}

}

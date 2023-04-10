package com.postoffice.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.postoffice.postofficemanagement.model.UserModel;

public class UserLoginMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel register = new UserModel();
		String userName = rs.getString("user_name");
		register.setUserName(userName);
		String password = rs.getString("password");
		register.setPassword(password);
		Long accoutNo = rs.getLong("account_no");
		register.setAccountNo(accoutNo);
		return register;
	}

}

package com.postoffice.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.postoffice.postofficemanagement.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel register = new UserModel();
		Long mobileNo = rs.getLong("mobile_no");
		register.setMobileNo(mobileNo);

		return register;
	}

}

package com.postoffice.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.postoffice.postofficemanagement.model.UserModel;

public class MailIdMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel register = new UserModel();
		String mailId = rs.getString("mail_id");
		register.setMailId(mailId);
		return register;
	}
}

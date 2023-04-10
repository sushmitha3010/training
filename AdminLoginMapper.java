package com.postoffice.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.postoffice.postofficemanagement.model.AdminModel;

public class AdminLoginMapper implements RowMapper<AdminModel> {

	@Override
	public AdminModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminModel admin = new AdminModel();
		String mailId = rs.getString("mail_id");
		admin.setMailId(mailId);
		String password = rs.getString("password");
		admin.setPassword(password);
		return admin;
	}

}

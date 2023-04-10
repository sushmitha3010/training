package com.postoffice.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.postoffice.postofficemanagement.model.UserModel;

public class MobileNomapper implements RowMapper<UserModel> {

	
	@Autowired
	UserModel  register;
	
	
	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Long acctNo=rs.getLong("account_no");
		
		register.setAccountNo(acctNo);
		
		return register;
	}

}

package com.postoffice.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobileNo1Exception extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		Logger logger = LoggerFactory.getLogger(MobileNo1Exception.class);
		logger.info("Invalid MobileNo!!!...Mobile No Must Contain 10 Digits and Not Allowed for Alphabets");
	}

}

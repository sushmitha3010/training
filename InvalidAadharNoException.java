package com.postoffice.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InvalidAadharNoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		Logger logger = LoggerFactory.getLogger(InvalidAadharNoException.class);
		logger.info("Invalid AadharNo!!!...Aadhar No Must Contain 12 Digits and Not Allowed for Alphabets");
	}
}

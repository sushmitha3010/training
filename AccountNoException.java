package com.postoffice.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountNoException  extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		Logger logger = LoggerFactory.getLogger(AccountNoException.class);
		logger.info("Invalid AccountNo!!!...Account No Must Contain 12 Digits and Not Allowed for Alphabets");
	}

}

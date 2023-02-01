package com.te.resumebuilder.exceptions;

import com.te.resumebuilder.enums.GlobalEnums;

@SuppressWarnings("serial")
public class UserException extends RuntimeException implements GlobalEnums{
	
	public UserException(String message) {
		super(message);
	}

}

package com.te.resumebuilder.exceptions;

import com.te.resumebuilder.enums.GlobalEnums;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException implements GlobalEnums{
	
	public UserNotFoundException() {
		super(SOMETHING_WENT_WRONG);
	}
	public UserNotFoundException(String message) {
		super(message);
	}

}

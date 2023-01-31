package com.te.resumebuilder.exceptions;

import com.te.resumebuilder.enums.GlobalEnums;

@SuppressWarnings("serial")
public class ProfileException extends RuntimeException implements GlobalEnums {
	
	public ProfileException() {
		super(SOMETHING_WENT_WRONG);
	}
	

	public ProfileException(String message) {
		super(message);
	}
}

package com.te.resumebuilder.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.resumebuilder.exceptions.ProfileException;
import com.te.resumebuilder.response.AppResponse;

@RestControllerAdvice
public class GlobalExceptionalHandler {
	
	@ExceptionHandler(ProfileException.class)
	public ResponseEntity<AppResponse> handleProfileNotSavedException(
			ProfileException profileException) {
		return new ResponseEntity<AppResponse>(new AppResponse(false, profileException.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
}

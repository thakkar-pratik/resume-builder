package com.te.resumebuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.dto.NewUserDto;
import com.te.resumebuilder.response.AppResponse;
import com.te.resumebuilder.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Operation(description = "To register a new user")
	@PostMapping("/register")
	public ResponseEntity<Object> addUser(@RequestBody NewUserDto newUserDto) {
		NewUserDto userDto = userService.addUser(newUserDto);
		if (userDto != null) {
			return new ResponseEntity<Object>(new AppResponse(true, "User added successfully"), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new AppResponse(false, "Error occurred please try again later"),
					HttpStatus.BAD_REQUEST);
		}
	}

}

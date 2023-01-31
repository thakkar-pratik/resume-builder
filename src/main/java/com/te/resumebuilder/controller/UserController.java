package com.te.resumebuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.dto.ProfileDto;
import com.te.resumebuilder.response.AppResponse;
import com.te.resumebuilder.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(description = "To add data to profile")
	@PostMapping("")
	public ResponseEntity<AppResponse> addDataToResume(@RequestBody ProfileDto profileDto) {
		userService.addDataToResume(profileDto);
		return new ResponseEntity<AppResponse>(new AppResponse(true, "Profile saved successfully"), HttpStatus.CREATED);
	}

	@Operation(description = "To fetch data of particular profile")
	@GetMapping("/{profileid}")
	public ResponseEntity<Object> getDataOfUser(@PathVariable Integer profileid) {
		ProfileDto profileDto = userService.getUserDetails(profileid);
		if (profileDto != null) {
			return new ResponseEntity<>(profileDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new AppResponse(false,"Data Not Found for this profile"),HttpStatus.NOT_FOUND);
		}
	}

}

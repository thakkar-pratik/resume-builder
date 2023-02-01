package com.te.resumebuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/v1")
@EnableMethodSecurity
@SecurityRequirement(name = "javainuseapi")
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(description = "To add data to profile")
	@PostMapping("/addprofile/{emailId}")
	public ResponseEntity<AppResponse> addDataToResume(@RequestBody ProfileDto profileDto,@PathVariable String emailId) {
		userService.addDataToResume(profileDto, emailId);
		return new ResponseEntity<AppResponse>(new AppResponse(true, "Profile saved successfully"), HttpStatus.CREATED);
	}

	@Operation(description = "To fetch data of particular profile")
	@GetMapping("/download/{profileid}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<Object> getDataOfUser(@PathVariable Integer profileid) {
		ProfileDto profileDto = userService.getUserDetails(profileid);
		if (profileDto != null) {
			return new ResponseEntity<>(profileDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new AppResponse(false, "Data not found for this profile"),
					HttpStatus.NOT_FOUND);
		}
	}

	

}

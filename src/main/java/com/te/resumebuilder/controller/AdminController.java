package com.te.resumebuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.dto.ProfileDto;
import com.te.resumebuilder.response.AppResponse;
import com.te.resumebuilder.service.AdminService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/v1/admin")
@EnableMethodSecurity
@SecurityRequirement(name = "javainuseapi")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Object> getDataOfAllProfiles() {
		List<ProfileDto> profileDto = adminService.getAllProfiles();
		if (profileDto != null) {
			return new ResponseEntity<Object>(profileDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new AppResponse(false, "No Profiles available"), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("{profileid}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Object> deleteProfile(@PathVariable Integer profileid) {
		String message = adminService.deleteProfileData(profileid);
		if (message != null) {
			return new ResponseEntity<Object>(new AppResponse(true, message), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new AppResponse(false,"Not Deleted please try again later"), HttpStatus.BAD_REQUEST);
		}
	}

}

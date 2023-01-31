package com.te.resumebuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.dto.ProfileDto;
import com.te.resumebuilder.response.AppResponse;
import com.te.resumebuilder.service.AdminService;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("")
	public ResponseEntity<Object> getDataOfAllProfiles() {
		List<ProfileDto> profileDto = adminService.getAllProfiles();
		if (profileDto != null) {
			return new ResponseEntity<Object>(profileDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new AppResponse(false, "No Profiles available"), HttpStatus.BAD_REQUEST);
		}

	}

}

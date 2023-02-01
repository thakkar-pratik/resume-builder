package com.te.resumebuilder.service;

import com.te.resumebuilder.dto.NewUserDto;
import com.te.resumebuilder.dto.ProfileDto;

public interface UserService {

	ProfileDto addDataToResume(ProfileDto profileDto, String emailId);

	ProfileDto getUserDetails(Integer profileid);

	NewUserDto addUser(NewUserDto newUserDto);

	

}

package com.te.resumebuilder.service;

import com.te.resumebuilder.dto.ProfileDto;

public interface UserService {

	ProfileDto addDataToResume(ProfileDto profileDto);

	ProfileDto getUserDetails(Integer profileid);

	

}

package com.te.resumebuilder.service;

import java.util.List;

import com.te.resumebuilder.dto.ProfileDto;


public interface AdminService {

	List<ProfileDto> getAllProfiles();

	String deleteProfileData(Integer profileid);

}

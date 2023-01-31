package com.te.resumebuilder.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.resumebuilder.dto.ProfileDto;
import com.te.resumebuilder.entity.Profile;
import com.te.resumebuilder.enums.GlobalEnums;
import com.te.resumebuilder.exceptions.ProfileException;
import com.te.resumebuilder.repository.ProfileRepository;
import com.te.resumebuilder.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService, GlobalEnums {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProfileDto> getAllProfiles() {
		List<Profile> profiles = profileRepository.findAll();
		System.out.println(profiles);
		if (profiles != null) {
			List<ProfileDto> profileDtos = new ArrayList<>();
			for(Profile profile: profiles) {
				ProfileDto dto = new ProfileDto();
				modelMapper.map(profile, dto);
				profileDtos.add(dto);				
			}
			return profileDtos;
		}else {
			throw new ProfileException(PROFILES_NOT_FOUND);
		}
	}

}

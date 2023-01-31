package com.te.resumebuilder.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.resumebuilder.dto.ProfileDto;
import com.te.resumebuilder.entity.EducationDetails;
import com.te.resumebuilder.entity.Profile;
import com.te.resumebuilder.entity.Skills;
import com.te.resumebuilder.enums.GlobalEnums;
import com.te.resumebuilder.exceptions.ProfileException;
import com.te.resumebuilder.repository.EducationRepository;
import com.te.resumebuilder.repository.ProfileRepository;
import com.te.resumebuilder.service.UserService;

@Service
public class UserServiceImpl implements UserService,GlobalEnums {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private EducationRepository educationRepository;

//	@Autowired
//	private SummaryRepository summaryRepository;

//	@Autowired
//	private ProjectDetailsRepository projectDetailsRepository;

//	@Autowired
//	private SkillsRepository skillsRepository;

	@Override
	public ProfileDto addDataToResume(ProfileDto profileDto) {
		Profile profile = new Profile();
		Skills skills = new Skills();
		modelMapper.map(profileDto.getSkills(), skills);
		modelMapper.map(profileDto, profile);
		profile.setSkills(skills);
		Profile savedProfile = profileRepository.save(profile);
		if (savedProfile != null) {
			List<EducationDetails> educationDetails = new ArrayList<EducationDetails>();
			savedProfile.getSkills().setProfile(savedProfile);
			Profile finalProfile = profileRepository.save(savedProfile);
			educationDetails = finalProfile.getEducationDetails();
			educationDetails.forEach(edu -> edu.setProfile(finalProfile));
			educationRepository.saveAll(educationDetails);
			modelMapper.map(finalProfile, profileDto);
			return profileDto;
		} else {
			throw new ProfileException(PROFILE_NOT_SAVED);
		}
	}

	@Override
	public ProfileDto getUserDetails(Integer profileid) {
		Profile profile = profileRepository.findById(profileid).orElseThrow(()-> new ProfileException(PROFILE_NOT_FOUND));
		ProfileDto dto = new ProfileDto();
		modelMapper.map(profile, dto);
		return dto;
	}

}

package com.te.resumebuilder.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
		
	private String userFirstName;
	
	private String userLastName;
	
	private List<String> userTechnologies;
	
	private String userTotalExperience; 
	
	private String relevantExperience;
	
	
//	===========================================================
	
	
	private List<SummaryDto> summarys;
	
	private AchievementsDto achievements;
		
	private List<EducationDetailsDto> educationDetails;
		
	private List<ProjectDetailsDto> projectDetails;

	private SkillsDto skills;


}

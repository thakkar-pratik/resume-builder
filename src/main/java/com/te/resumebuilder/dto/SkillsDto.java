package com.te.resumebuilder.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class SkillsDto {
	
	private List<String> frontEndTechnologies;


	private List<String> backEndTechnologies;

	
	private List<String> designPatterns;


	private List<String> databases;


	private List<String> developmentTools;

	
	private List<String> versionControlSystems;


	private List<String> aws;

	
	private List<String> sdlc;
	
	
	private List<String> middleWareTechnologies;

}

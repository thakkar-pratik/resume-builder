package com.te.resumebuilder.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDetailsDto {
	
	
	private List<String> frontEndTechnologies;

	
	private List<String> backEndTechnologies;

	
	private List<String> designPatterns;

	
	private List<String> databases;

	
	private List<String> developmentTools;

	
	private String duration;

	
	private int teamSize;

	private String description;

	
	private String rolesAndResponsibilities;


}

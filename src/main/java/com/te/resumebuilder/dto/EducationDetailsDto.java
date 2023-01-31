package com.te.resumebuilder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EducationDetailsDto {
	
	
	private String education;
	
	private String specialization;
	
	private String university;
	
	private int yearOfPassout;
	
	private double percentage;

}

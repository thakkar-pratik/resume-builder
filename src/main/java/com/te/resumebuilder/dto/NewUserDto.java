package com.te.resumebuilder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewUserDto {
	
	private String emailId;
	
	private String password;
	
	private String roles;

}

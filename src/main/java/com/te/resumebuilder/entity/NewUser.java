package com.te.resumebuilder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewUser {
	
	@Id
	@Column(name = "email_id",nullable = false)
	private String emailId;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "roles",nullable = false)
	private String roles;
	
	@OneToOne(mappedBy = "newUser")
	@JsonIgnore
	private Profile profile;

}

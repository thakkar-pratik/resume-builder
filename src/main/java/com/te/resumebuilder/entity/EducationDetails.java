package com.te.resumebuilder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "education_details")
public class EducationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String education;
	
	private String specialization;
	
	@Column(nullable = false)
	private String university;
	
	@Column(nullable = false,name = "YOP")
	private int yearOfPassout;
	
	@Column(nullable = false)
	private double percentage;
	
	
	@ManyToOne
	@JoinColumn(name = "profile_id")
	@JsonIgnore
	private Profile profile;

}

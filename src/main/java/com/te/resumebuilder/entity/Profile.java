package com.te.resumebuilder.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "profile")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "first_name", nullable = false)
	private String userFirstName;
	
	@Column(name = "last_name", nullable = false)
	private String userLastName;
	
	@ElementCollection
	@CollectionTable(name = "profile_technologies", joinColumns = @JoinColumn(name="profile_id"))
	@Column(name = "technologies")
	private List<String> userTechnologies;
	
	@Column(name = "total_experience")
	private String userTotalExperience; 
	
	@Column(name = "relevant_experience")
	private String relevantExperience;

//	===========================================================
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Summary> summarys;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Achievements achievements;
	
	@OneToMany(mappedBy = "profile",cascade = CascadeType.ALL)
	private List<EducationDetails> educationDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProjectDetails> projectDetails;
	
	@OneToOne(mappedBy = "profile",cascade = CascadeType.ALL)
	private Skills skills;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_email")
	private NewUser newUser;
	
	
	
}

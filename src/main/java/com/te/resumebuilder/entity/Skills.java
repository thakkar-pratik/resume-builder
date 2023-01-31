package com.te.resumebuilder.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ElementCollection
	@CollectionTable(name = "skills_frontend_technologies", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "frontend_technologies")
	private List<String> frontEndTechnologies;

	@ElementCollection
	@CollectionTable(name = "skills_backend_technologies", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "backend_technologies")
	private List<String> backEndTechnologies;

	@ElementCollection
	@CollectionTable(name = "skills_design_pattern", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "design_patterns")
	private List<String> designPatterns;

	@ElementCollection
	@CollectionTable(name = "skills_details_databases", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "skills_databases")
	private List<String> databases;

	@ElementCollection
	@CollectionTable(name = "skills_development_tools", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "development_tools")
	private List<String> developmentTools;

	@ElementCollection
	@CollectionTable(name = "skills_version_control_sys", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "version_control_sys")
	private List<String> versionControlSystems;

	@ElementCollection
	@CollectionTable(name = "skills_aws", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "aws")
	private List<String> aws;

	@ElementCollection
	@CollectionTable(name = "skills_sdlc", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "sdlc")
	private List<String> sdlc;
	
	@ElementCollection
	@CollectionTable(name = "skills_middleware_technologies", joinColumns = @JoinColumn(name="skills_id"))
	@Column(name = "middle_ware_technologies")
	private List<String> middleWareTechnologies;
	
	@OneToOne
	@JoinColumn(name = "profile_id")
	@JsonIgnore
	private Profile profile;

}

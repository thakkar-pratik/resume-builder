package com.te.resumebuilder.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "project_details")
public class ProjectDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ElementCollection
	@CollectionTable(name = "projects_frontend_technologies", joinColumns = @JoinColumn(name="projects_id"))
	@Column(name = "frontend_technologies")
	private List<String> frontEndTechnologies;

	@ElementCollection
	@CollectionTable(name = "projects_backend_technologies", joinColumns = @JoinColumn(name="projects_id"))
	@Column(name = "backend_technologies")
	private List<String> backEndTechnologies;

	@ElementCollection
	@CollectionTable(name = "projects_design_patterns", joinColumns = @JoinColumn(name="projects_id"))
	@Column(name = "design_patterns")
	private List<String> designPatterns;

	@ElementCollection
	@CollectionTable(name = "projects_details_databases", joinColumns = @JoinColumn(name="projects_id"))
	@Column(name = "projects_databases")
	private List<String> databases;

	@ElementCollection
	@CollectionTable(name = "projects_development_tools", joinColumns = @JoinColumn(name="projects_id"))
	@Column(name = "development_tools")
	private List<String> developmentTools;

	@Column(nullable = false)
	private String duration;

	@Column(name = "team_size")
	private int teamSize;

	private String description;

	@Column(name = "roles_reponsibilities")
	private String rolesAndResponsibilities;

}

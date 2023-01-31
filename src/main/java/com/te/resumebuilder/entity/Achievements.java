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

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="achievements")
public class Achievements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="achievement_id")
	private Integer id;
	
	@ElementCollection
	@CollectionTable(name="achievement_details",joinColumns = @JoinColumn(name="achievement_id"))
	@Column(name="achievement")
	private List<String> achievement;

}

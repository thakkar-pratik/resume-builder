package com.te.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.Achievements;

@Repository
public interface AchievementsRepository extends JpaRepository<Achievements, Integer> {

}

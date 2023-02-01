package com.te.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.NewUser;

@Repository
public interface NewUserRepository extends JpaRepository<NewUser, Integer> {

	Optional<NewUser> findByEmailId(String username);

}

package com.te.resumebuilder.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.te.resumebuilder.config.NewUserDetails;
import com.te.resumebuilder.entity.NewUser;
import com.te.resumebuilder.enums.GlobalEnums;
import com.te.resumebuilder.exceptions.UserNotFoundException;
import com.te.resumebuilder.repository.NewUserRepository;

public class NewUserDetailsService implements UserDetailsService, GlobalEnums {

	@Autowired
	private NewUserRepository newUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<NewUser> optUser = newUserRepository.findByEmailId(username);
		return optUser.map(NewUserDetails::new).orElseThrow(() -> new UserNotFoundException(INVALID_LOGIN + username));
	}
}

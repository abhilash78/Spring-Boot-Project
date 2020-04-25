/**
 
@author Avinash_Kumar

created on 22-Apr-2020 5:54:05 pm

 */
package com.photoshop.photoapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.photoshop.photoapp.shared.dto.UserDto;

public interface UserService extends UserDetailsService {
	
	 UserDto createUser(UserDto userDto);

	/**
	 * @author Avinash Kumar
	  created on 24-Apr-2020 1:49:08 am
	 */
	UserDto getUser(String email);

	/**
	 * @author Avinash Kumar
	  created on 24-Apr-2020 6:17:45 pm
	 */
	UserDto getUserById(String id);	
}

/**
 
@author Avinash Kumar 

created on 21-Apr-2020

 */
package com.photoshop.photoapp.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photoshop.photoapp.io.entity.UserEntity;
import com.photoshop.photoapp.service.UserService;
import com.photoshop.photoapp.shared.dto.UserDto;
import com.photoshop.photoapp.ui.model.request.UserDetailsRequestModel;
import com.photoshop.photoapp.ui.model.response.UserRest;


@RestController
@RequestMapping("users") // http://localhost:8080/users

public class UserController {

	/**
	 * @return
	  created on 21-Apr-2020
	 */
	@Autowired	
	UserService userService;	
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})	
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)
	{
		
		UserDto dto = new UserDto();	
		BeanUtils.copyProperties(userDetails, dto);
		
		UserDto createdUser = userService.createUser(dto);
		
		UserRest returnValue = new UserRest();

		BeanUtils.copyProperties(createdUser, returnValue);

		
		return returnValue;
	}
	
	/**
	 * @return
	  created on 21-Apr-2020
	 */
	
	@PutMapping	
	public String updateUser()
	{
		return "updateUser user was called";
	}
	
	/**
	 * @return
	  created on 21-Apr-2020
	 */
	
	@DeleteMapping	
	public String deleteUser()
	{
		return "deleteUser user was called";
	}
	
	/**
	 * @return
	  created on 21-Apr-2020
	 */
	
	@GetMapping(path="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})	
	public UserRest getUser(@PathVariable String id)
	{
		
		//UserEntity user = userRepository.findByUserId(id);
		UserRest returnValue = new UserRest();
		
		
		
		//UserDto userDto = new UserDto();

		UserDto userDto = userService.getUserById(id);
		
		BeanUtils.copyProperties(userDto, returnValue);
		
		
		
		return returnValue;
	}
	
}

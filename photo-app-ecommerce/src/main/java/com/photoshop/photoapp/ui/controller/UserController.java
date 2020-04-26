/**
 
@author Avinash Kumar 

created on 21-Apr-2020

 */
package com.photoshop.photoapp.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.photoshop.photoapp.ui.model.response.OperationStatusModel;
import com.photoshop.photoapp.ui.model.response.RequestOperationName;
import com.photoshop.photoapp.ui.model.response.RequestOperationStatus;
import com.photoshop.photoapp.app.ws.exceptions.UserServiceException;
import com.photoshop.photoapp.io.entity.UserEntity;
import com.photoshop.photoapp.service.UserService;
import com.photoshop.photoapp.shared.dto.UserDto;
import com.photoshop.photoapp.ui.model.request.UserDetailsRequestModel;
import com.photoshop.photoapp.ui.model.response.ErrorMessages;
import com.photoshop.photoapp.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8080/users

public class UserController {

	/**
	 * @return created on 21-Apr-2020
	 */
	@Autowired
	UserService userService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception {

		if (userDetails.getFirstName().isEmpty())
			throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

		UserDto dto = new UserDto();
		BeanUtils.copyProperties(userDetails, dto);

		UserDto createdUser = userService.createUser(dto);

		UserRest returnValue = new UserRest();

		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	/**
	 * @return created on 21-Apr-2020
	 */

	@PutMapping("/{userId}")
	public UserRest updateUser(@PathVariable String userId, @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();

		if (userDetails.getFirstName().isEmpty())
			throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto updatedUser = userService.updateUser(userId, userDto);
		BeanUtils.copyProperties(updatedUser, returnValue);

		return returnValue;
	}

	/**
	 * @return created on 21-Apr-2020
	 */

	@DeleteMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteUser(@PathVariable String id) {
		OperationStatusModel retunValue = new OperationStatusModel();
		retunValue.setOperationName(RequestOperationName.DELETE.name());
		retunValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		userService.deleteUser(id);
		retunValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return retunValue;
	}

	/**
	 * @return created on 21-Apr-2020
	 */

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserRest getUser(@PathVariable String id) throws Exception {

		// UserEntity user = userRepository.findByUserId(id);
		UserRest returnValue = new UserRest();

		// UserDto userDto = new UserDto();

		UserDto userDto = userService.getUserById(id);

		BeanUtils.copyProperties(userDto, returnValue);

		return returnValue;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		List<UserRest> returnValue = new ArrayList<UserRest>();
		List<UserDto> users = userService.getUsers(page, limit);

		for (UserDto userDto : users) {
			UserRest userRest = new UserRest();
			BeanUtils.copyProperties(userDto, userRest);
			returnValue.add(userRest);
		}
		return returnValue;
	}

}

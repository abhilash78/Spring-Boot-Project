/**
 
@author Avinash_Kumar

created on 22-Apr-2020 6:09:20 pm

 */
package com.photoshop.photoapp.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.photoshop.photoapp.ui.model.response.ErrorMessages;
import com.photoshop.photoapp.ui.model.response.UserRest;
import com.photoshop.photoapp.app.ws.exceptions.UserServiceException;
import com.photoshop.photoapp.io.entity.UserEntity;
import com.photoshop.photoapp.io.repository.UserRepository;
import com.photoshop.photoapp.service.UserService;
import com.photoshop.photoapp.shared.dto.UserDto;
import com.photoshop.photoapp.shared.utils.Utils;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	/* (non-Javadoc)
	 * @see com.photoshop.photoapp.service.UserService#createUser(com.photoshop.photoapp.shared.dto.UserDto)
	 */
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		UserEntity email = userRepository.findByEmail(userDto.getEmail());
		
		if(email!=null) throw new RuntimeException("Record Already exists !!! ");
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(userDto, userEntity);
		String userId= utils.generateUserId(30);
		userEntity.setUserId(userId);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		UserEntity user = userRepository.save(userEntity);
		
		UserDto response = new UserDto();
		
		BeanUtils.copyProperties(user, response);

		return response;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = userRepository.findByEmail(username);
		
		if(userEntity==null) throw new UsernameNotFoundException(username);
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}

	/* (non-Javadoc)
	 * @see com.photoshop.photoapp.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
 
		return returnValue;
	}

	/* (non-Javadoc)
	 * @see com.photoshop.photoapp.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public UserDto getUserById(String id) {
		// TODO Auto-generated method stub
		
		UserEntity user = userRepository.findByUserId(id);
		if(user == null )throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		UserDto userDto = new UserDto();
		
		if(user==null) throw new UsernameNotFoundException(id);
		
		BeanUtils.copyProperties(user, userDto);
		
		return userDto;
	}

	@Override
	public UserDto updateUser(String userId,UserDto userDto) {
		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		
		UserEntity updatedUserDetails=userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(updatedUserDetails, returnValue);

				return returnValue;

			}
	
	@Override
	public void deleteUser(String userId) {
		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		userRepository.delete(userEntity);;
	}

	@Override
	public List<UserDto> getUsers(int page, int limit) {
List<UserDto> retrunValue=new ArrayList<UserDto>();
Pageable pageableRequest=PageRequest.of(page,limit);
   Page<UserEntity> userPage=  userRepository.findAll(pageableRequest);
   List<UserEntity> users=userPage.toList();
   
   for (UserEntity userEntity : users) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userEntity, userDto);
		retrunValue.add(userDto);
	}


		return retrunValue;
	}


}

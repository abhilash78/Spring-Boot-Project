/**
 
@author Avinash_Kumar

created on 22-Apr-2020 6:50:33 pm

 */
package com.photoshop.photoapp.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.photoshop.photoapp.io.entity.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);

	/**
	 * @author Avinash Kumar
	  created on 24-Apr-2020 6:20:19 pm
	 */
	UserEntity findByUserId(String id);
}

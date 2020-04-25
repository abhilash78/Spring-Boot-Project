/**
 
@author Avinash_Kumar

created on 22-Apr-2020 6:37:00 pm

 */
package com.photoshop.photoapp.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")

public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String userId;

	@Column(nullable=false, length=50)
	private String firstName;
	
	@Column(nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, length=120 , unique=true)
	private String email;
	
	@Column(nullable=false)
	private String encryptedPassword;
	
	private String emailVerificationToken;
	
	@Column(nullable=false)
	private Boolean emailVerificationStatus = false;

	/**
	 * @return the id
	   
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	   
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	   
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	   
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	   
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the encryptedPassword
	   
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	/**
	 * @param encryptedPassword the encryptedPassword to set
	
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	/**
	 * @return the emailVerificationToken
	   
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	/**
	 * @param emailVerificationToken the emailVerificationToken to set
	
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	/**
	 * @return the emailVerificationStatus
	   
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	/**
	 * @param emailVerificationStatus the emailVerificationStatus to set
	
	   created on 22-Apr-2020 6:42:04 pm
	
	 */
	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
	
	

}

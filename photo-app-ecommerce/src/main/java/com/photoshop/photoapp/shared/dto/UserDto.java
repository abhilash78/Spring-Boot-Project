/**
 
@author Avinash_Kumar

created on 22-Apr-2020 12:54:53 pm

 */
package com.photoshop.photoapp.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
	/**
	 * @return the id
	   
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the userId
	   
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the firstName
	   
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	   
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	   
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	   
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the encryptedPassword
	   
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	/**
	 * @param encryptedPassword the encryptedPassword to set
	
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	/**
	 * @return the emailVerificationToken
	   
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}
	/**
	 * @param emailVerificationToken the emailVerificationToken to set
	
	   created on 22-Apr-2020 12:59:26 pm
	
	 */
	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

}

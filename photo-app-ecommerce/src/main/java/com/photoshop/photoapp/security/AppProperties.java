/**
 
@author Avinash_Kumar

created on 24-Apr-2020 5:31:25 pm

 */
package com.photoshop.photoapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class AppProperties {

	
	@Autowired
	Environment env;

	/**
	 * @return the env
	   
	   created on 24-Apr-2020 5:33:14 pm
	
	 */
	public String getTokenSecret() {
		return env.getProperty("tokenSecret");
	}
	
	
}

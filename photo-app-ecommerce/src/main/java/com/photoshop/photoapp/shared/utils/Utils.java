/**
 
@author Avinash_Kumar

created on 23-Apr-2020 11:55:33 am

 */
package com.photoshop.photoapp.shared.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class Utils {

//	utils commited
	private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
    public String generateUserId(int length) {
        return generateRandomString(length);
    }
    
    public String generateAddressId(int length) {
        return generateRandomString(length);
    }
    
    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }


	
}

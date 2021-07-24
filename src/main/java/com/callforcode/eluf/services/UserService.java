package com.callforcode.eluf.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.callforcode.eluf.security.UserSS;


public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
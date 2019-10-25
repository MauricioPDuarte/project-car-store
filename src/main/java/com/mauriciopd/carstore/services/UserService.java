package com.mauriciopd.carstore.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.mauriciopd.carstore.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) {
			return null;
		}
	}
}

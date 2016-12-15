package com.nuvizz.busticket.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDTO implements Serializable {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginDTO.class);

	private String username;
	private String password;

	public LoginDTO() {
		logger.info(this.getClass().getSimpleName() + " created !!");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [username=" + username + "]";
	}

}

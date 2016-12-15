package com.nuvizz.car.service.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.car.dao.login.LoginDAOImpl;
import com.nuvizz.car.dto.login.LoginDTO;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAOImpl dao;

	private static final Logger logger = LoggerFactory
			.getLogger(LoginServiceImpl.class);

	public LoginDTO loginService(LoginDTO dto) {
		logger.info("Starting login Service");

		LoginDTO fDto = null;
		try {
			if (dto.getUid() != null && dto.getPassword() != null) {
				logger.info("UserId and password found");
				fDto = dao.authenticate(dto);
			} else {
				logger.info("userId & password not found");
			}
		} catch (Exception e) {
			logger.error("Exception in service state " + e);
			e.printStackTrace();
		}

		logger.info("Ending login Service");

		return fDto;
	}

}

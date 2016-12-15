package com.nuvizz.busticket.service.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.busticket.dao.login.LoginDAOImpl;
import com.nuvizz.busticket.dto.LoginDTO;
import com.nuvizz.busticket.dto.UserDTO;

@Component
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginServiceImpl.class);
	
	@Autowired
	LoginDAOImpl dao;

	public LoginServiceImpl() {
		logger.info("login service created..");
	}

	public UserDTO loginService(LoginDTO dto) {
		logger.info("Starting login Service");

		UserDTO dto2 = null;
		try {
			if (dto.getUsername() != null && dto.getPassword() != null) {
				logger.info("Username and password found");
				dto2 = dao.authenticateUser(dto);
				return dto2;
			} else {
				logger.info("username & password not found");
			}
		} catch (Exception e) {
			logger.error("Exception in service state " + e);
			e.printStackTrace();
		}

		logger.info("Ending login Service");

		return dto2;

	}

	public String sendUserIdService(String email) {

		logger.info("Starting forgot id Service");

		String fromDB = null;
		try {
			if (email != null) {
				logger.info("Email found");
				fromDB = dao.sendUserId(email);
			} else {
				logger.info("Email not found");
			}
		} catch (Exception e) {
			logger.error("Exception in service state " + e);
			e.printStackTrace();
		}

		logger.info("Ending forgot id Service");

		return fromDB;

	}

	public boolean changePasswordService(String email, String pass, String cpass) {
		logger.info("Starting change password Service");

		boolean res = false;
		try {
			if (email != null && pass != null && cpass != null) {
				res = dao.changePassword(email, pass, cpass);
			}
		} catch (Exception e) {
			logger.error("Exception in changing password service" + e);
			e.printStackTrace();
		}

		logger.info("Ending change password Service");

		return res;

	}

}

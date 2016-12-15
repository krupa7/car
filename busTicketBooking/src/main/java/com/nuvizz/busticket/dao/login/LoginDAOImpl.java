package com.nuvizz.busticket.dao.login;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.busticket.dto.LoginDTO;
import com.nuvizz.busticket.dto.RoleDTO;
import com.nuvizz.busticket.dto.UserDTO;

@Component
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public LoginDAOImpl() {
		logger.info("login dao created...");
	}

	public UserDTO authenticateUser(LoginDTO dto) {

		logger.info("Inside login dao");

		UserDTO fromDB = null;

		if (dto != null) {
			//String pass = dto.getPassword();
			//String encry = AESCrypt.encrypt(pass);

			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select user from UserDTO user where user.username=:nm and user.password=:pass";
				//logger.info(dto.getUserId());
				//logger.info(dto.getPassword());
				Query q = session.createQuery(s1);
				q.setParameter("nm", dto.getUsername());
				q.setParameter("pass", dto.getPassword());
				
				fromDB = (UserDTO) q.uniqueResult();
			
				//logger.info(fromDB);
				return fromDB;

			} catch (HibernateException he) {
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}
		}
		logger.info("exiting login dao");

		return fromDB;
	}

	public String sendUserId(String email) {

		logger.info("Inside forgot userid dao");

		String emailFromDB = null;

		if (email != null) {
			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select reg.fname from RegistrationDTO reg where reg.email=:email";
				Query q = session.createQuery(s1);
				q.setParameter("email", email);
				emailFromDB = (String) q.uniqueResult();
				logger.info(emailFromDB);

			} catch (HibernateException he) {
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}
		}
		logger.info("exiting forgot id dao");

		return emailFromDB;

	}

	public boolean changePassword(String email, String pass, String cpass) {
		logger.info("Inside change password dao");

		int res = 0;
		boolean result = false;
		Session session = null;
		Transaction tx = null;
		if (email != null) {

			if (pass.equals(cpass)) {

				try {
					session = factory.openSession();
					tx = session.beginTransaction();
	//				String encryptPass = AESCrypt.encrypt(pass);
		//			String encryptCpass = AESCrypt.encrypt(cpass);
					String s1 = "update RegistrationDTO reg set reg.password=?,reg.cpass=? where reg.email='"
							+ email + "'";
					Query q = session.createQuery(s1);
				//	q.setParameter(0, encryptPass);
			//		q.setParameter(1, encryptCpass);
					res = q.executeUpdate();
					tx.commit();
					if (res == 1)
						result = true;

				} catch (HibernateException he) {
					logger.error("Exception " + he.getMessage());
					tx.rollback();
					he.printStackTrace();
				} finally {
					session.close();
				}

			}
		}

		logger.info("exiting change password dao");

		return result;

	}

	/*
	 * public boolean checkEmailId(String email) {
	 * 
	 * logger.info("Inside check email dao");
	 * 
	 * boolean res = false; RegistrationDTO fromDB = null;
	 * 
	 * if (email != null) { Session session = null; try { session =
	 * factory.openSession();
	 * 
	 * String s1 = "select reg from RegistrationDTO reg where reg.email=:email";
	 * Query q = session.createQuery(s1); q.setParameter("email", email); fromDB
	 * = (RegistrationDTO) q.uniqueResult(); if (fromDB != null) res = true;
	 * 
	 * } catch (HibernateException he) { logger.error("Exception " +
	 * he.getMessage()); he.printStackTrace(); } finally { session.close(); } }
	 * logger.info("exiting fcheck email dao");
	 * 
	 * return res;
	 * 
	 * }
	 */
}

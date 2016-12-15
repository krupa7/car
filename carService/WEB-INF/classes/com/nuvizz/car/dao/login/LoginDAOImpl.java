package com.nuvizz.car.dao.login;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.car.dto.login.LoginDTO;

@Component
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public LoginDTO authenticate(LoginDTO dto) {
		logger.info("Inside login dao");

		LoginDTO fromDB = null;
		String uid = dto.getUid();
		String pass = dto.getPassword();
		logger.info("uid"+uid + "\t" + pass);
		if (dto != null) {
			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select l from LoginDTO l where l.uid=:id and l.password=:pass";
				Query q = session.createQuery(s1);
				q.setParameter("id",uid);
				q.setParameter("pass", pass);
				fromDB = (LoginDTO) q.uniqueResult();

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

}

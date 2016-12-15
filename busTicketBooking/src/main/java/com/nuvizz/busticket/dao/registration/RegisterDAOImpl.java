package com.nuvizz.busticket.dao.registration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuvizz.busticket.dto.CityDTO;
import com.nuvizz.busticket.dto.CountryDTO;
import com.nuvizz.busticket.dto.RoleDTO;
import com.nuvizz.busticket.dto.StateDTO;
import com.nuvizz.busticket.dto.UserDTO;

@Component
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:../spring/context.xml")
*/public class RegisterDAOImpl implements RegisterDAO {

	//@InjectMocks
	@Autowired
	private SessionFactory factory;
	

	private static final Logger logger = LoggerFactory
			.getLogger(RegisterDAOImpl.class);

	public boolean registerUser(UserDTO dto) {
		logger.info("Starting register DAO");
		boolean res = false;
		if (dto != null) {

			Session s = null;
			Transaction t = null;

			try {
				s = factory.openSession();
				t = s.beginTransaction();
				RoleDTO roleDTO = s.get(RoleDTO.class, 2);
				Collection<RoleDTO> list=new ArrayList<RoleDTO>();
				list.add(roleDTO);
				dto.setRdtos(list);
				s.save(dto);
				t.commit();
				res = true;
			} catch (HibernateException he) {
				t.rollback();
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				s.close();
			}

		}

		logger.info("Ending register DAO");
		return res;
	}

	public java.util.List<CountryDTO> fetchCountry() {
		logger.info("starting fetch country dao");
		Session s = null;
		List<CountryDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "from CountryDTO";
			Query q = s.createQuery(s1);
			dtos = q.list();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("ending fetch country dao");
		return dtos;
	}

	public List<StateDTO> fetchState(String country) {
		logger.info("starting fetch state dao");
		Session s = null;
		CountryDTO countryDTO = null;
		List<StateDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "select c from CountryDTO c where c.country=:con";
			Query q = s.createQuery(s1);
			q.setParameter("con", country);
			countryDTO = (CountryDTO) q.uniqueResult();
			dtos = (List<StateDTO>) countryDTO.getDtos();

			for (StateDTO stateDTO : dtos) {
				System.out.println(stateDTO);
			}
			return dtos;

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("ending fetch state dao");
		return dtos;
	}

	public List<CityDTO> fetchCity(String state) {
		logger.info("starting fetch city dao");
		Session s = null;
		StateDTO stateDTO = null;
		List<CityDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "select s from StateDTO s where s.state=:state";
			Query q = s.createQuery(s1);
			q.setParameter("state", state);
			stateDTO = (StateDTO) q.uniqueResult();
			dtos = (List<CityDTO>) stateDTO.getDtos();
			for (CityDTO cityDTO : dtos) {
				System.out.println(cityDTO);
			}
			return dtos;

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("ending fetch city dao");
		return dtos;
	}

	public List<CityDTO> fetchAllCity() {
		logger.info("starting fetch all city dao");
		Session s = null;
		List<CityDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "from StateDTO";
			Query q = s.createQuery(s1);
			dtos = q.list();
			return dtos;

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("ending fetch all city dao");
		return dtos;
	}

}

package com.nuvizz.busticket.service.registration;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuvizz.busticket.dao.registration.RegisterDAOImpl;
import com.nuvizz.busticket.dto.CityDTO;
import com.nuvizz.busticket.dto.CountryDTO;
import com.nuvizz.busticket.dto.StateDTO;
import com.nuvizz.busticket.dto.UserDTO;

@Component
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:../spring/context.xml")
*/public class RegisterServiceImpl implements RegisterService {

//	@InjectMocks
	@Autowired
	private RegisterDAOImpl dao;

	private static final Logger logger = LoggerFactory
			.getLogger(RegisterServiceImpl.class);

	// @Test
	public boolean registerUserService(UserDTO dto) {
		logger.info("Starting register Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.registerUser(dto);
				// assertEquals(true,res);

			} catch (Exception e) {
				logger.error("Exception in save service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending register Service");

		return res;
	}

	public List<CountryDTO> fetchCountryService() {
		logger.info("Starting fetch country Service");
		List<CountryDTO> dtos = null;
		try {
			dtos = dao.fetchCountry();
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch country Service");

		return dtos;
	}

	public List<StateDTO> fetchStateService(String country) {
		logger.info("Starting fetch state Service");
		List<StateDTO> dtos = null;
		try {
			dtos = dao.fetchState(country);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch state Service");

		return dtos;
	}

	public List<CityDTO> fetchCityService(String state) {
		logger.info("Starting fetch city Service");
		List<CityDTO> dtos = null;
		try {
			dtos = dao.fetchCity(state);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch city Service");

		return dtos;
	}

	public List<CityDTO> fetchAllCityService() {
		logger.info("Starting fetch all city Service");
		List<CityDTO> dtos = null;
		try {
			dtos = dao.fetchAllCity();
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch all city Service");

		return dtos;
	}

}

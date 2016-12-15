/*package com.nuvizz.busticket.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuvizz.busticket.dao.registration.RegisterDAOImpl;
import com.nuvizz.busticket.dto.UserDTO;
import com.nuvizz.busticket.service.registration.RegisterServiceImpl;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:../spring/context.xml")
public class ServiceUnitTesting {

	@InjectMocks
	RegisterServiceImpl impl;

	@Mock
	RegisterDAOImpl dao;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {

		UserDTO dto1 = new UserDTO();
		dto1.setUsername("naman");
		dto1.setLastname("shah");
		dto1.setPassword("qwerty");
		dto1.setCpass("qwerty");
		dto1.setEmail("gstads@gmail.com");
		dto1.setPhoneNo(634765435);
		dto1.setCountry("India");
		dto1.setState("Maharastra");
		dto1.setCity("Pune");
		dto1.setAddress1("gchjdsc");
		// RegisterDAOImpl dao1=new RegisterDAOImpl();
		boolean res = impl.registerUserService(dto1);

		assertEquals(true, res);
		// assertTrue(res);
	}

}
*/
package com.nuvizz.bustest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.service.admin.AdminServiceImpl;
import com.nuvizz.busticket.service.registration.RegisterServiceImpl;
import com.nuvizz.busticket.service.user.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:contextTest.xml")
public class Tester {

	@Autowired
	AdminServiceImpl impl;

	@Autowired
	RegisterServiceImpl service;

	@Autowired
	UserServiceImpl uimpl;

	@Test
	public void chechProvider() {
		List<ProviderDTO> list = impl.fetchProvidersService();
		int count = list.size();
		assertEquals(6, count);

	}

	/*
	 * @Test public void test() {
	 * 
	 * UserDTO dto1 = new UserDTO(); dto1.setUsername("naman");
	 * dto1.setLastname("shah"); dto1.setPassword("qwerty");
	 * dto1.setCpass("qwerty"); dto1.setEmail("gstads@gmail.com");
	 * dto1.setPhoneNo(634765435); dto1.setCountry("India");
	 * dto1.setState("Maharastra"); dto1.setCity("Pune");
	 * dto1.setAddress1("gchjdsc"); dto1.setAddress2("ahsc"); boolean res =
	 * service.registerUserService(dto1);
	 * 
	 * assertEquals(true, res); }
	 */

	@Test
	public void testbusService() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date d = sdf.parse("2016-12-14");

		List<ServiceDTO> dtos = uimpl.searchBusService("Bangalore", "Pune", d);
		int c = dtos.size();
		assertEquals(3, c);

	}
}

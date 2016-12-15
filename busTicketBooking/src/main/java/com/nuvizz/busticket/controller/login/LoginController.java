package com.nuvizz.busticket.controller.login;

import java.util.List;

import javax.persistence.Temporal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nuvizz.busticket.dto.CountryDTO;
import com.nuvizz.busticket.dto.LoginDTO;
import com.nuvizz.busticket.dto.RoleDTO;
import com.nuvizz.busticket.dto.UserDTO;
import com.nuvizz.busticket.service.login.LoginServiceImpl;
import com.nuvizz.busticket.service.registration.RegisterServiceImpl;

@Component
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginServiceImpl impl;

	@Autowired
	private RegisterServiceImpl impl1;

	@RequestMapping(value = "/welcome.do", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request) {
		List<CountryDTO> list = impl1.fetchCountryService();
		HttpSession session = request.getSession(true);
		session.setAttribute("country", list);
		return "Login";
	}

//	@Test
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginDTO dto, HttpServletRequest request) {

		if (dto != null) {
			UserDTO userDTO = impl.loginService(dto);
			
			//assertEquals(UserDT,userDTO);
			System.out.println("dto" + userDTO);
			if (userDTO != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("uname", dto.getUsername());
				session.setAttribute("uid", userDTO.getId());
				session.setAttribute("user", userDTO);
				List<RoleDTO> list = (List<RoleDTO>) userDTO.getRdtos();
				for (RoleDTO roleDTO : list) {
					System.out.println("r" + roleDTO);
					if (roleDTO.getRid() == 2)
						return "UserHome";
					else
						return "AdminHome";
				}
			}

		}
		return "Login";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("uid");
		session.removeAttribute("user");

		session.invalidate();
		return "Login";
	}

}

package com.nuvizz.busticket.controller.registration;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.classic.Logger;

import com.nuvizz.busticket.dto.UserDTO;
import com.nuvizz.busticket.service.registration.RegisterServiceImpl;

@Component
@RequestMapping("/")
public class RegisterController {

	private static final Logger logger = (Logger) LoggerFactory
			.getLogger(RegisterController.class);

	@Autowired
	RegisterServiceImpl impl;

	@Autowired
	private MailSender mailSender;

	@RequestMapping(value = "newreg.do", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request) {

		return "Register";
	}


	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String register(@ModelAttribute UserDTO dto,
			HttpServletRequest request) {
		if (dto.getPassword().equals(dto.getCpass())) {
			boolean res = impl.registerUserService(dto);

		
			if (res) {
				SimpleMailMessage email = new SimpleMailMessage();
				email.setTo(dto.getEmail());
				// email.setFrom("kknaik.busticket@gmail.com");
				email.setSubject("Registration");
				email.setText("Hello !! "
						+ dto.getUsername()
						+ " , Registration Successful...Welcome to Bus ticket Booking !!! Enjoy booking with us ! ");
				// JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
				mailSender.send(email);

				return "Success";
			}

		}

		return "Register";
	}

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String homelogin() {
		return "Login";
	}

}

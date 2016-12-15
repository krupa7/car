package com.nuvizz.car.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nuvizz.car.dto.carservice.CarServiceDTO;
import com.nuvizz.car.dto.carservice.ManufacturerDTO;
import com.nuvizz.car.dto.login.LoginDTO;
import com.nuvizz.car.service.carservice.CarDetailServiceImpl;
import com.nuvizz.car.service.login.LoginServiceImpl;


//first change

@Component
@RequestMapping("/")
public class CarServiceController {

	@Autowired
	private LoginServiceImpl impl;

	@Autowired
	private CarDetailServiceImpl impl1;

	public CarServiceController() {
		System.out.println(this.getClass().getSimpleName() + " Created !!");
	}

	@RequestMapping("welcome.do")
	public String welcome(HttpServletRequest request) {
		return "Login";
	}

	@RequestMapping("login.do")
	public String login(@ModelAttribute LoginDTO dto, HttpServletRequest request) {
		System.out.println("dto=" + dto);
		LoginDTO loginDTO = impl.loginService(dto);
		if (loginDTO != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", dto.getUid());
			return "Home";
		}
		return "Error";
	}

	@RequestMapping("serviceCar.do")
	public String carDetail(HttpServletRequest request) {
		List<ManufacturerDTO> dtos = impl1.fetchManufacturerService();
		request.setAttribute("manu", dtos);

		return "ServiceCar";
	}

	@RequestMapping("procedure.do")
	public String callProcedure(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("name");

		List<CarServiceDTO> list = impl1.callProcedureService(name);
		if (list != null) {
			request.setAttribute("records", list);
			return "FetchRecords";
		}
		return "Error";

	}

	@RequestMapping("service.do")
	public String register(@ModelAttribute CarServiceDTO dto,
			HttpServletRequest request) {
		boolean res;
		Date d = new Date();
		Date checkDate = impl1.checkService(dto);
		if (checkDate != null) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(checkDate);
			cal.add(Calendar.DATE, 1);
			Date d2 = cal.getTime();
			if (checkDate.compareTo(d2) < 0) {
				request.setAttribute("date", d2);
				return "Fail";
			}
		} else {
			dto.setDate(d);
			res = impl1.saveService(dto);
			if (res) {
				request.setAttribute("obj", dto);
				HttpSession session=request.getSession(true);
				session.setAttribute("name", dto.getOwner());

				return "Acknowledgement";
			}

		}
		return "Fail";

	}

}

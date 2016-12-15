package com.nuvizz.busticket.controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.dto.UserDTO;
import com.nuvizz.busticket.service.admin.AdminServiceImpl;
import com.nuvizz.busticket.service.user.UserServiceImpl;

@Component
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserServiceImpl impl;

	@Autowired
	private AdminServiceImpl impl1;

	@Autowired
	private MailSender mailSender;

	@RequestMapping(value = "home1.do", method = RequestMethod.GET)
	public String home() {
		return "UserHome";
	}

	@RequestMapping(value = "search.do", method = RequestMethod.GET)
	public String search(HttpServletRequest request) {
		List<String> slist = impl.fetchSourceService();
		List<String> dlist = impl.fetchDestinationService();

		request.setAttribute("slist", slist);
		request.setAttribute("dlist", dlist);

		return "BookBus";
	}

	@RequestMapping(value = "searchBus.do", method = RequestMethod.POST)
	public String searchBus(HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		String source = request.getParameter("source");
		String dest = request.getParameter("destination");
		String dateStr = request.getParameter("date1");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date startDate = sdf.parse(dateStr);
			System.out.println("date" + startDate);
			session.setAttribute("source", source);
			session.setAttribute("dest", dest);
			session.setAttribute("strdate", startDate);
			// System.out.println("sou" + source + "dest" + dest);
			List<ServiceDTO> dtos = impl.searchBusService(source, dest,
					startDate);

			if (dtos != null) {
				session.setAttribute("bus", dtos);
				return "DisplayBus";
			} else
				return "Error";

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";

	}

	@RequestMapping(value = "booking.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String booking(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int seat = impl.fetchSeatsService(id);
		if (seat > 0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("seat", seat);
			session.setAttribute("bid", id);
			return "SelectSeat";
		}
		return null;
	}

	@RequestMapping(value = "confirmBooking.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String confirm(@ModelAttribute OrderDTO orderDTO,
			HttpServletRequest request) {
		ServiceDTO dto = null;
		HttpSession session = request.getSession(false);
		int seat = (Integer) session.getAttribute("seat");
		int ticket = Integer.parseInt(request.getParameter("num"));
		int bid = (Integer) session.getAttribute("bid");
		UserDTO userDTO=(UserDTO) session.getAttribute("user");
		seat = seat - ticket;
		boolean res = impl.updateSeatService(seat, bid);
		if (res) {
			Date d = new Date();
			dto = impl1.getBusServiceById(bid);
			request.setAttribute("bdto", dto);
			session.setAttribute("tno", ticket);
			orderDTO.setUsername((String) session.getAttribute("uname"));
			orderDTO.setSource((String) session.getAttribute("source"));
			orderDTO.setDestination((String) session.getAttribute("dest"));
			orderDTO.setTicket(ticket);
			orderDTO.setBookdate(d);
			orderDTO.setBusname(dto.getBusName());
			boolean res1 = impl.saveOrderService(orderDTO);
			if (res1) {
				SimpleMailMessage email = new SimpleMailMessage();
				email.setTo(userDTO.getEmail());
				email.setSubject("Ticket Booked !!");
				email.setText("Hello !! "
						+ userDTO.getUsername());
				email.setText("Booking Details.....");
				email.setText("Bus Name :"+dto.getBusName());
				email.setText("Bus Number :"+dto.getRegNo());
				email.setText("Driver Name :"+dto.getDriverName());
				email.setText("Contact Number :"+dto.getContactNo());
				email.setText("Source :"+dto.getSource());
				email.setText("Destination :"+dto.getDestination());
				email.setText("Bus will be arrive on :"+dto.getArrival()+" and Departure time is "+dto.getDeparture());
				email.setText("Joueney DATE is :"+dto.getDdate());
				email.setText("Please reach on time.."+"\n"+"Thank you for Booking...Have a great journey!!!");
				mailSender.send(email);
				return "Acknowledgement";
			}

		}

		return null;
	}

	@RequestMapping(value = "profile.do", method = RequestMethod.GET)
	public String viewprofile(HttpServletRequest request) {
		return "ViewProfile";
	}

	@RequestMapping(value = "updatePro.do", method = RequestMethod.GET)
	public String updatePro() {
		return "UpdateProfile";
	}

	@RequestMapping(value = "updateProfile.do", method = RequestMethod.POST)
	public String updateprofile(@ModelAttribute UserDTO dto,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("uid");
		String name = (String) session.getAttribute("uname");
		dto.setId(id);
		dto.setUsername(name);
		boolean res = impl.updateProfileService(dto);
		if (res) {
			session.setAttribute("user", dto);
			return "ViewProfile";
		}
		return "UpdateProfile";
	}

	@RequestMapping(value = "sort.do", method = RequestMethod.GET)
	public String sorting(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		// List<ServiceDTO> dtos=(List<ServiceDTO>) session.getAttribute("bus");
		String src = (String) session.getAttribute("source");
		String dest = (String) session.getAttribute("dest");
		Date date = (Date) session.getAttribute("strdate");
		System.out.println("src" + src + "dest" + dest);

		List<ServiceDTO> dtos = impl.sortingService(src, dest, date);
		if (dtos != null) {
			session.setAttribute("bus", dtos);
			return "DisplayBus";
		}

		return null;
	}

	@RequestMapping(value = "order.do", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("uname");
		List<OrderDTO> dtos = impl.fetchOrderByNameService(name);
		if (dtos != null) {
			request.setAttribute("order", dtos);
			return "ViewOrderUser";
		}
		return "Error1";

	}

	@RequestMapping(value = "forgot.do", method = RequestMethod.GET)
	public String forgot() {
		return "Forgot";

	}

	@RequestMapping(value = "forgotUserId.do", method = RequestMethod.GET)
	public String forgotUsername() {
		return "ForgotUserId";
	}

	@RequestMapping(value = "sendId.do", method = RequestMethod.POST)
	public String sendId(@ModelAttribute UserDTO dto, HttpServletRequest request) {

		String email = dto.getEmail();
		String userId = impl.sendUserIdService(email);
		if (userId != null) {

			request.setAttribute("userId", userId);
			return "RecoverUserId";
		} else
			return "Fail";

	}

	@RequestMapping(value = "forgotPassword.do", method = RequestMethod.GET)
	public String forgotPass() {
		return "ForgotPassword";
	}

	@RequestMapping(value = "sendPassword.do", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute UserDTO dto,
			HttpServletRequest request) {

		String email = dto.getEmail();
		String pass = request.getParameter("password");
		String cpass = request.getParameter("cpass");
		boolean res = impl.changePasswordService(email, pass, cpass);
		if (res)
			return "PasswordChanged";
		else
			return "Fail";

	}

}

package com.nuvizz.busticket.service.user;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.busticket.dao.admin.AdminDAOImpl;
import com.nuvizz.busticket.dao.user.UserDAOImpl;
import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.dto.UserDTO;

@Component
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAOImpl dao;

	public List<String> fetchSourceService() {
		logger.info("Starting fetch source Service");
		List<String> list = null;
		try {
			list = dao.fetchSource();
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch source Service");

		return list;
	}

	public List<String> fetchDestinationService() {
		logger.info("Starting fetch destination Service");
		List<String> list = null;
		try {
			list = dao.fetchDestination();
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch destination Service");

		return list;
	}

	public List<ServiceDTO> searchBusService(String source, String dest, Date d) {
		logger.info("Starting fetch bus Service");
		List<ServiceDTO> list = null;
		try {
			list = dao.searchBus(source, dest, d);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch bus Service");

		return list;
	}

	public int fetchSeatsService(int id) {
		logger.info("Starting fetch seat Service");
		int seat = 0;
		try {
			seat = dao.fetchSeats(id);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch seat Service");

		return seat;
	}

	public boolean updateSeatService(int seat, int id) {
		logger.info("Starting update seat Service");
		boolean res = false;
		try {
			res = dao.updateSeat(seat, id);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending update seat Service");

		return res;
	}

	public UserDTO getUserByIdService(int id) {
		logger.info("Starting get user Service");
		UserDTO dto = null;
		try {
			dto = dao.getUserById(id);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending get user Service");

		return dto;
	}

	public boolean updateProfileService(UserDTO dto) {
		logger.info("Starting update profile Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.updateProfile(dto);
			} catch (Exception e) {
				logger.error("Exception in service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending update profile Service");

		return res;
	}

	public List<ServiceDTO> sortingService(String src, String dest, Date date) {
		logger.info("Starting fetch bus Service");
		List<ServiceDTO> list = null;
		try {
			list = dao.sorting(src, dest, date);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch bus Service");

		return list;
	}

	public boolean saveOrderService(OrderDTO dto) {
		logger.info("Starting save order Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.saveOrder(dto);
			} catch (Exception e) {
				logger.error("Exception in save service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending save order Service");

		return res;
	}

	public List<OrderDTO> fetchOrderByNameService(String name) {
		logger.info("Starting fetch order by name Service");
		List<OrderDTO> list = null;
		try {
			list = dao.fetchOrderByName(name);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch order by name Service");

		return list;
	}

	public String sendUserIdService(String email) {

		logger.info("Starting forgot id Service");

		String fromDB = null;
		try {
			if (email != null) {
				logger.info("Email found");
				fromDB = dao.sendUserId(email);
			} else {
				logger.info("Email not found");
			}
		} catch (Exception e) {
			logger.error("Exception in service state " + e);
			e.printStackTrace();
		}

		logger.info("Ending forgot id Service");

		return fromDB;

	}

	public boolean changePasswordService(String email, String pass, String cpass) {
		logger.info("Starting change password Service");

		boolean res = false;
		try {
			if (email != null && pass != null && cpass != null) {
				res = dao.changePassword(email, pass, cpass);
			}
		} catch (Exception e) {
			logger.error("Exception in changing password service" + e);
			e.printStackTrace();
		}

		logger.info("Ending change password Service");

		return res;

	}

	public UserDTO checkEmailService(String email) {
		logger.info("Starting getemail Service");
		UserDTO dto = null;
		try {
			dto = dao.checkEmail(email);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending get email Service");

		return dto;
	}
}

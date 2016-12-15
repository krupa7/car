package com.nuvizz.busticket.dao.user;

import java.util.Date;
import java.util.List;

import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.dto.UserDTO;

public interface UserDAO {

	List<String> fetchSource();
	List<String> fetchDestination();
	List<ServiceDTO> searchBus(String source,String dest,Date d);
	int fetchSeats(int id);
	boolean updateSeat(int seat,int id);
	UserDTO getUserById(int id);
	boolean updateProfile(UserDTO dto);
	List<ServiceDTO> sorting(String src,String dest,Date date);
	boolean saveOrder(OrderDTO dto);
	List<OrderDTO> fetchOrderByName(String name);
	String sendUserId(String email);
	boolean changePassword(String email,String pass,String cpass);
	UserDTO checkEmail(String email);
	
}

package com.nuvizz.busticket.service.user;

import java.util.Date;
import java.util.List;

import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.dto.UserDTO;

public interface UserService {

	List<String> fetchSourceService();
	List<String> fetchDestinationService();
	List<ServiceDTO> searchBusService(String source,String dest,Date d);
	int fetchSeatsService(int id);
	boolean updateSeatService(int seat,int id);
	UserDTO getUserByIdService(int id);
	boolean updateProfileService(UserDTO dto);
	List<ServiceDTO> sortingService(String src,String dest,Date date);
	boolean saveOrderService(OrderDTO dto);
	List<OrderDTO> fetchOrderByNameService(String name);

	String sendUserIdService(String email);
	boolean changePasswordService(String email,String pass,String cpass);
	UserDTO checkEmailService(String email);


}

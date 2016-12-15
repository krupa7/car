package com.nuvizz.busticket.service.admin;

import java.util.List;

import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;

public interface AdminService {
	List<ProviderDTO> fetchProvidersService();
	boolean addProService(ProviderDTO dto);
	ProviderDTO getProviderService(int id);
	boolean updateProviderService(ProviderDTO dto);
	boolean deleteProviderService(int id);
	List<ServiceDTO> fetchServiceById(int id);
	boolean addSer(ServiceDTO dto);
	ServiceDTO getBusServiceById(int id);
	boolean updateBusService(ServiceDTO dto);
	boolean deleteBusService(int id);
	ProviderDTO getProviderByName(String name);
	List<OrderDTO> fetchOrderService();


	
}

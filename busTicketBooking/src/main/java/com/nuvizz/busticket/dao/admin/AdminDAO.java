package com.nuvizz.busticket.dao.admin;

import java.util.List;

import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;

public interface AdminDAO {

	List<ProviderDTO> fetchProviders();
	boolean addProvider(ProviderDTO dto);
	ProviderDTO getProvider(int id);
	boolean updateProvider(ProviderDTO dto);
	boolean deleteProvider(int id);
	List<ServiceDTO> fetchService(int id);
	boolean addService(ServiceDTO dto);
	ServiceDTO getBusService(int id);
	boolean updateService(ServiceDTO dto);
	boolean deleteService(int id);
	ProviderDTO getProviderByName(String name);
	List<OrderDTO> fetchOrder();

}

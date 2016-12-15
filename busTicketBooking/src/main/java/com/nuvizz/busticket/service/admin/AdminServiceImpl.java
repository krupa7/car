package com.nuvizz.busticket.service.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.busticket.dao.admin.AdminDAOImpl;
import com.nuvizz.busticket.dto.CountryDTO;
import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.service.registration.RegisterServiceImpl;

@Component
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAOImpl dao;

	private static final Logger logger = LoggerFactory
			.getLogger(RegisterServiceImpl.class);

	public List<ProviderDTO> fetchProvidersService() {
		logger.info("Starting fetch provider Service");
		List<ProviderDTO> dtos = null;
		try {
			dtos = dao.fetchProviders();
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch provider Service");

		return dtos;
	}

	public boolean addProService(ProviderDTO dto) {
		logger.info("Starting add pro Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.addProvider(dto);
			} catch (Exception e) {
				logger.error("Exception in save service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending add pro Service");

		return res;
	}

	public ProviderDTO getProviderService(int id) {
		logger.info("Starting getPro Service");

		ProviderDTO fromDB = null;
		try {
			if (id > 0) {
				logger.info("id found");
				fromDB = dao.getProvider(id);
			} else {
				logger.info("id found");
			}
		} catch (Exception e) {
			logger.error("Exception in service state " + e);
			e.printStackTrace();
		}

		logger.info("Ending getPro Service");

		return fromDB;
	}

	public boolean updateProviderService(ProviderDTO dto) {
		logger.info("Starting update pro Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.updateProvider(dto);
			} catch (Exception e) {
				logger.error("Exception in service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending update pro Service");

		return res;
	}

	public boolean deleteProviderService(int id) {
		logger.info("Starting delete pro Service");
		boolean res = false;
		if (id > 0) {
			try {
				res = dao.deleteProvider(id);
			} catch (Exception e) {
				logger.error("Exception in service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending delete pro Service");

		return res;
	}

	public List<ServiceDTO> fetchServiceById(int id) {
		logger.info("Starting fetch service Service");

		List<ServiceDTO> fromDB = null;
		try {
			if (id > 0) {
				logger.info("id found");
				fromDB = dao.fetchService(id);
			} else {
				logger.info("id not found");
			}
		} catch (Exception e) {
			logger.error("Exception in service state " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch service Service");

		return fromDB;
	}

	public boolean addSer(ServiceDTO dto) {
		logger.info("Starting add ser Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.addService(dto);
			} catch (Exception e) {
				logger.error("Exception in save service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending add ser Service");

		return res;
	}

	public ServiceDTO getBusServiceById(int id) {
		logger.info("Starting getService Bus Service");

		ServiceDTO fromDB = null;
		try {
			if (id > 0) {
				logger.info("id found");
				fromDB = dao.getBusService(id);
			} else {
				logger.info("id found");
			}
		} catch (Exception e) {
			logger.error("Exception in service state " + e);
			e.printStackTrace();
		}

		logger.info("Ending get Service bus Service");

		return fromDB;
	}

	public boolean updateBusService(ServiceDTO dto) {
		logger.info("Starting update busServ Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.updateService(dto);
			} catch (Exception e) {
				logger.error("Exception in service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending update busServ Service");

		return res;
	}

	public boolean deleteBusService(int id) {
		logger.info("Starting delete busServ Service");
		boolean res = false;
		if (id > 0) {
			try {
				res = dao.deleteService(id);
			} catch (Exception e) {
				logger.error("Exception in service " + e);
				e.printStackTrace();
			}
		}

		logger.info("Ending delete busServ Service");

		return res;
	}

	public ProviderDTO getProviderByName(String name) {
		logger.info("Starting getPro Service");

		ProviderDTO fromDB = null;
		try {
			if (name!=null) {
				logger.info("name found");
				fromDB = dao.getProviderByName(name);
			} else {
				logger.info("name not found");
			}
		} catch (Exception e) {
			logger.error("Exception in service state " + e);
			e.printStackTrace();
		}

		logger.info("Ending getPro Service");

		return fromDB;
	}

	public List<OrderDTO> fetchOrderService() {
		logger.info("Starting fetch order Service");
		List<OrderDTO> list = null;
		try {
			list = dao.fetchOrder();
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		logger.info("Ending fetch order Service");

		return list;
	}

}

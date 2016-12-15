package com.nuvizz.busticket.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.classic.Logger;

import com.nuvizz.busticket.controller.registration.RegisterController;
import com.nuvizz.busticket.dto.CityDTO;
import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.service.admin.AdminServiceImpl;
import com.nuvizz.busticket.service.registration.RegisterServiceImpl;
import com.sun.org.apache.regexp.internal.recompile;

@Component
@RequestMapping("/")
public class AdminController {

	private static final Logger logger = (Logger) LoggerFactory
			.getLogger(AdminController.class);

	@Autowired
	private AdminServiceImpl impl;

	@Autowired
	private RegisterServiceImpl impl1;

	public AdminController() {
		System.out.println(this.getClass().getSimpleName() + " created!!");
	}

	@RequestMapping(value = "/provider.do", method = RequestMethod.GET)
	public String provider(HttpServletRequest request) {
		List<ProviderDTO> dtos = impl.fetchProvidersService();
		HttpSession session = request.getSession(true);
		session.setAttribute("pro", dtos);
		return "DisplayProvider";
	}

	@RequestMapping(value = "/addprovider.do", method = RequestMethod.GET)
	public String addprovider(HttpServletRequest request) {
		return "AddProvider";
	}

	@RequestMapping(value = "addpro.do", method = RequestMethod.POST)
	public String add(@ModelAttribute ProviderDTO dto,HttpServletRequest request) {
		boolean res = impl.addProService(dto);
		if (res)
		{
			List<ProviderDTO> dtos = impl.fetchProvidersService();
			HttpSession session=request.getSession(false);
			session.setAttribute("pro", dtos);
			return "DisplayProvider";
		}
		else
			return "AddProvider";
	}

	@RequestMapping(value = "edit.do", method = RequestMethod.GET)
	public String edit(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id1"));
		ProviderDTO dto = null;
		if (id > 0) {
			dto = impl.getProviderService(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("pdto", dto);
			return "UpdateProvider";

		}
		return null;

	}

	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute ProviderDTO dto,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		ProviderDTO dto2 = (ProviderDTO) session.getAttribute("pdto");
		dto.setPid(dto2.getPid());
		dto.setPname(dto2.getPname());
		boolean res = impl.updateProviderService(dto);
		if (res) {

			List<ProviderDTO> dtos = impl.fetchProvidersService();
			session.setAttribute("pro", dtos);
			return "DisplayProvider";
		}
		return null;

	}

	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id2"));
		HttpSession session = request.getSession(false);
		boolean res = false;
		if (id > 0) {
			res = impl.deleteProviderService(id);
			if (res) {
				List<ProviderDTO> dtos = impl.fetchProvidersService();
				session.setAttribute("pro", dtos);
				return "DisplayProvider";
			}
		}
		return null;
	}

	@RequestMapping(value = "viewservice.do", method = RequestMethod.GET)
	public String viewService(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id3"));
		List<ServiceDTO> dtos = null;
		ProviderDTO dto = null;
		if (id > 0) {
			// dtos = impl.fetchServiceById(id);
			dto = impl.getProviderService(id);
			dtos = (List<ServiceDTO>) dto.getServiceDTOs();
			for (ServiceDTO serviceDTO : dtos) {
				System.out.println(serviceDTO);
			}

			if (dtos != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("service", dtos);
				session.setAttribute("proid", id);
				return "DisplayService";
			}

		}

		return null;

	}

	/*
	 * @RequestMapping("service.do") public String service(HttpServletRequest
	 * request) { // List<ProviderDTO> dtos=impl.fetchProvidersService(); //
	 * HttpSession session=request.getSession(false);
	 * 
	 * return "ViewService"; }
	 */

	@RequestMapping(value = "viewBus.do", method = RequestMethod.GET)
	public String servicebus(HttpServletRequest request) {
		String provider = request.getParameter("provider");

		return "ViewService";
	}

	@RequestMapping(value = "addservice.do", method = RequestMethod.GET)
	public String addService(HttpServletRequest request) {
		// int id = Integer.parseInt(request.getParameter("id6"));

		return "AddService";
	}

	@RequestMapping(value = "addser.do", method = RequestMethod.POST)
	public String addSer(@ModelAttribute ServiceDTO dto,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int pid = (Integer) session.getAttribute("proid");
		// int id = (Integer) request.getAttribute("id3");
		ProviderDTO providerDTO = impl.getProviderService(pid);
		dto.setProviderDTO(providerDTO);
		/*String dateStr = request.getParameter("ddate");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		*///try {
		//	Date d=sdf.parse(dateStr);
			//Calendar cl=Calendar.getInstance();
			
			//java.sql.Date d= new java.sql.Date(sdf.parse(dateStr).getDate());
			//System.out.println("dd"+d);
			//dto.setDdate(d);
			boolean res = impl.addSer(dto);
			if (res) {
				List<ServiceDTO> dtos = (List<ServiceDTO>) providerDTO
						.getServiceDTOs();
				session.setAttribute("service", dtos);
				return "DisplayService";
			}
		/*} catch (ParseException e) {
			e.printStackTrace();
		}*/

		return "AddService";
	}

	@RequestMapping(value = "edit1.do", method = RequestMethod.GET)
	public String editService(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id4"));
		ServiceDTO dto = null;
		if (id > 0) {
			dto = impl.getBusServiceById(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("sdto", dto);
			return "UpdateService";

		}

		return null;

	}

	@RequestMapping(value = "editser.do", method = RequestMethod.POST)
	public String updateSer(@ModelAttribute ServiceDTO dto,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		ServiceDTO dto2 = (ServiceDTO) session.getAttribute("sdto");
		int pid = (Integer) session.getAttribute("proid");
		// System.out.println("pid"+pid);
		ProviderDTO providerDTO = impl.getProviderService(pid);
		dto.setProviderDTO(providerDTO);
		// System.out.println("sid" + dto2.getId() + "name" +
		// dto2.getBusName());
		dto.setId(dto2.getId());
		dto.setBusName(dto2.getBusName());
		boolean res = impl.updateBusService(dto);
		if (res) {
			List<ServiceDTO> dtos = (List<ServiceDTO>) providerDTO
					.getServiceDTOs();
			session.setAttribute("service", dtos);
			return "DisplayService";
		}
		return null;

	}

	@RequestMapping(value = "delete1.do", method = RequestMethod.GET)
	public String deleteSer(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int id = Integer.parseInt(request.getParameter("id5"));
		int pid = (Integer) session.getAttribute("proid");
		boolean res = false;
		if (id > 0) {
			res = impl.deleteBusService(id);
			if (res) {
				ProviderDTO providerDTO = impl.getProviderService(pid);
				List<ServiceDTO> dtos = (List<ServiceDTO>) providerDTO
						.getServiceDTOs();
				session.setAttribute("service", dtos);
				return "DisplayService";
			}
		}
		return null;

	}

	@RequestMapping(value = "order1.do", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("uname");
		List<OrderDTO> dtos = impl.fetchOrderService();
		if (dtos != null) {
			request.setAttribute("order1", dtos);
			return "ViewOrderAdmin";
		}
		return "Error1";

	}

}

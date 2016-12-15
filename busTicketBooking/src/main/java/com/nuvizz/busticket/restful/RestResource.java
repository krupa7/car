package com.nuvizz.busticket.restful;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.busticket.dto.BusService;
import com.nuvizz.busticket.dto.CityDTO;
import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.dto.StateDTO;
import com.nuvizz.busticket.dto.UserDTO;
import com.nuvizz.busticket.service.admin.AdminServiceImpl;
import com.nuvizz.busticket.service.registration.RegisterServiceImpl;
import com.nuvizz.busticket.service.user.UserServiceImpl;

@Component
@Path("/rest")
public class RestResource {

	@Autowired
	private RegisterServiceImpl impl;

	@Autowired
	private AdminServiceImpl impl1;
	
	@Autowired
	private UserServiceImpl impl2;

	@GET
	@Path("/fetchState/{country}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchstate(@PathParam("country") String country) {
		List<StateDTO> list = impl.fetchStateService(country);

		if (list != null)
			return Response.status(Status.OK).entity(list).build();
		else
			return Response.status(Status.OK).entity("Fail").build();

	}

	@GET
	@Path("/fetchCity/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchcity(@PathParam("state") String state) {
		List<CityDTO> list = impl.fetchCityService(state);

		if (list != null)
			return Response.status(Status.OK).entity(list).build();
		else
			return Response.status(Status.OK).entity("Fail").build();

	}

	@GET
	@Path("/checkEmail/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response emailCheck(@PathParam("email") String email) {
		UserDTO uDto =impl2.checkEmailService(email);

		if (uDto != null)
			return Response.status(Status.OK).entity(uDto).build();
		else
			return Response.status(Status.OK).entity("Fail").build();

	}

	@POST
	@Path("/addservice")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addService(BusService busService) {

		boolean flag = false;
		String name = busService.getProviderName();
		ProviderDTO dto = impl1.getProviderByName(name);
		if (dto != null) {
			List<ServiceDTO> serviceDTOs = (List<ServiceDTO>) busService
					.getServiceDTOs();
			for (ServiceDTO serviceDTO : serviceDTOs) {
				serviceDTO.setProviderDTO(dto);
				boolean res = impl1.addSer(serviceDTO);
				if (res)
					return Response.status(Status.OK).entity("Success").build();
				else
					return Response.status(Status.OK).entity("Fail").build();
			}
		} else {
			return Response.status(Status.OK).entity("Provider Not Found")
					.build();
		}
		return null;

	}

}

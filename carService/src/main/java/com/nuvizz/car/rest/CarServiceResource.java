package com.nuvizz.car.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.car.dto.carservice.ModelDTO;
import com.nuvizz.car.service.carservice.CarDetailServiceImpl;

@Component
@Path("/rest")
public class CarServiceResource {

	public CarServiceResource() {
		System.out.println(this.getClass().getSimpleName() + " Created !!");
	}
	
	@Autowired
	private CarDetailServiceImpl impl;
	
	@GET
	@Path("/fetchModel/{model}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchall(@PathParam("model")String model) {
	List<ModelDTO> list=impl.fetchModelService(model);
		
		if (list!=null)
			return Response.status(Status.OK).entity(list).build();
		else
			return Response.status(Status.OK).entity("Fail").build();

	}
	
	
}

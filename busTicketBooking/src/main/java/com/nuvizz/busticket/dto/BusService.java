package com.nuvizz.busticket.dto;

import java.util.Collection;

public class BusService {

	private String providerName;
	private Collection<ServiceDTO> serviceDTOs;

	public BusService() {
		System.out.println("created");
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Collection<ServiceDTO> getServiceDTOs() {
		return serviceDTOs;
	}

	public void setServiceDTOs(Collection<ServiceDTO> serviceDTOs) {
		this.serviceDTOs = serviceDTOs;
	}

}

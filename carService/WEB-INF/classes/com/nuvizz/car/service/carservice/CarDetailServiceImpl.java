package com.nuvizz.car.service.carservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.car.dao.carservice.CarDetailDAOImpl;
import com.nuvizz.car.dto.carservice.CarServiceDTO;
import com.nuvizz.car.dto.carservice.ManufacturerDTO;
import com.nuvizz.car.dto.carservice.ModelDTO;

@Component
public class CarDetailServiceImpl implements CarDetailService {

	@Autowired
	private CarDetailDAOImpl dao;

	public List<ManufacturerDTO> fetchManufacturerService() {
		System.out.println("Starting view Service");
		List<ManufacturerDTO> dtos = null;
		try {
			dtos = dao.fetchManufacturer();
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		System.out.println("Ending view Service");

		return dtos;
	}

	public List<ModelDTO> fetchModelService(String manu) {
		System.out.println("Starting model Service");
		List<ModelDTO> dtos = null;
		try {
			dtos = dao.fetchModel(manu);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		System.out.println("Ending model Service");

		return dtos;
	}

	public boolean saveService(CarServiceDTO dto) {
		System.out.println("Starting save Service");
		boolean res = false;
		if (dto != null) {
			try {
				res = dao.save(dto);
			} catch (Exception e) {
				System.err.println("Exception in save service " + e);
				e.printStackTrace();
			}
		}

		System.out.println("Ending save Service");

		return res;
	}

	public Date checkService(CarServiceDTO dto) {
		System.out.println("Starting check Service");
		Date date = null;
		if (dto != null) {
			try {
				date = dao.check(dto);
			} catch (Exception e) {
				System.err.println("Exception in check service " + e);
				e.printStackTrace();
			}
		}

		System.out.println("Ending check Service");

		return date;
	}

	public List<CarServiceDTO> callProcedureService(String name) {
		System.out.println("Starting procedure Service");
		List<CarServiceDTO> dtos = null;
		try {
			dtos = dao.callProcedure(name);
		} catch (Exception e) {
			System.err.println("Exception " + e);
			e.printStackTrace();
		}

		System.out.println("Ending procedure Service");

		return dtos;
	}

}

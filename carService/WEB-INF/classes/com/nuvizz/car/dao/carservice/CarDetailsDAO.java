package com.nuvizz.car.dao.carservice;

import java.util.Date;
import java.util.List;

import com.nuvizz.car.dto.carservice.CarServiceDTO;
import com.nuvizz.car.dto.carservice.ManufacturerDTO;
import com.nuvizz.car.dto.carservice.ModelDTO;

public interface CarDetailsDAO {
	
	List<ManufacturerDTO> fetchManufacturer();
	List<ModelDTO> fetchModel(String manu);
	boolean save(CarServiceDTO dto);
	Date check(CarServiceDTO dto);
	List<CarServiceDTO> callProcedure(String name);
}

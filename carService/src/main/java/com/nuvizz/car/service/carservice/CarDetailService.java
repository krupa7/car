package com.nuvizz.car.service.carservice;

import java.util.Date;
import java.util.List;

import com.nuvizz.car.dto.carservice.CarServiceDTO;
import com.nuvizz.car.dto.carservice.ManufacturerDTO;
import com.nuvizz.car.dto.carservice.ModelDTO;

public interface CarDetailService {

	List<ManufacturerDTO> fetchManufacturerService();
	List<ModelDTO> fetchModelService(String manu);
	boolean saveService(CarServiceDTO dto);
	Date checkService(CarServiceDTO dto);
	List<CarServiceDTO> callProcedureService(String name);

}

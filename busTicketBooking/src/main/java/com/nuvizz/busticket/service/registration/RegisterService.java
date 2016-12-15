package com.nuvizz.busticket.service.registration;

import java.util.List;

import com.nuvizz.busticket.dto.CityDTO;
import com.nuvizz.busticket.dto.CountryDTO;
import com.nuvizz.busticket.dto.StateDTO;
import com.nuvizz.busticket.dto.UserDTO;

public interface RegisterService {
	boolean registerUserService(UserDTO dto);
	List<CountryDTO> fetchCountryService();
	List<StateDTO> fetchStateService(String country);
	List<CityDTO> fetchCityService(String state);
	List<CityDTO> fetchAllCityService();
}

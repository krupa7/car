package com.nuvizz.busticket.dao.registration;

import java.util.List;

import com.nuvizz.busticket.dto.CityDTO;
import com.nuvizz.busticket.dto.CountryDTO;
import com.nuvizz.busticket.dto.StateDTO;
import com.nuvizz.busticket.dto.UserDTO;

public interface RegisterDAO {

	boolean registerUser(UserDTO dto);
	List<CountryDTO> fetchCountry();
	List<StateDTO> fetchState(String country);
	List<CityDTO> fetchCity(String state);
	List<CityDTO> fetchAllCity();
	
}

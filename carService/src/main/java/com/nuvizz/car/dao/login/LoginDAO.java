package com.nuvizz.car.dao.login;

import com.nuvizz.car.dto.login.LoginDTO;

public interface LoginDAO {
	LoginDTO authenticate(LoginDTO dto);
}

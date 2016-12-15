package com.nuvizz.busticket.service.login;

import com.nuvizz.busticket.dto.LoginDTO;
import com.nuvizz.busticket.dto.UserDTO;

public interface LoginService {
	UserDTO loginService(LoginDTO dto);
	String sendUserIdService(String email);
	boolean changePasswordService(String email,String pass,String cpass);
}

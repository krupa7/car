package com.nuvizz.busticket.dao.login;

import com.nuvizz.busticket.dto.LoginDTO;
import com.nuvizz.busticket.dto.UserDTO;

public interface LoginDAO {
	UserDTO authenticateUser(LoginDTO dto);
	String sendUserId(String email);
	boolean changePassword(String email,String pass,String cpass);
}

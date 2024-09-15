package com.app.services;

import java.util.List;

import com.app.dto.LoginRequestDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserIdDTO;
import com.app.pojos.User;

public interface UserService {
	UserIdDTO addUser(UserDTO userDTO);
	List<User> getAllUsers();
	User authenticate(LoginRequestDTO loginRequest);
}

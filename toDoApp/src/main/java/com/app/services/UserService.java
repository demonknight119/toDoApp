package com.app.services;

import com.app.dto.UserDTO;
import com.app.dto.UserIdDTO;

public interface UserService {
	UserIdDTO addUser(UserDTO userDTO);
}

package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.app.dao.UserRepository;
import com.app.dto.LoginRequestDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserIdDTO;
import com.app.pojos.Role;
import com.app.pojos.User;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepo;
	public UserIdDTO addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = modelMapper.map(userDTO, User.class);
		user.setRole(Role.valueOf(userDTO.getRole().toUpperCase()));
		userRepo.save(user);
		UserIdDTO userIdDTO = modelMapper.map(user, UserIdDTO.class);
		System.out.println("UserIdDTO from UserServiceImpl"+userIdDTO);
		return userIdDTO;
	}
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findByRole(Role.USER);
		return users;
	}
	public User authenticate(LoginRequestDTO loginRequest) {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmail(loginRequest.getEmail());
		if(user!=null && user.getPassword().equals(loginRequest.getPassword()) && loginRequest.getRole().equals(user.getRole().toString().toUpperCase())) {
			return user;
		}
		return null;
	}

}

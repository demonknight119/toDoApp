package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.app.dao.UserRepository;
import com.app.dto.LoginRequestDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserIdDTO;
import com.app.exceptions.BadRequestException;
import com.app.exceptions.DuplicateEmailException;
import com.app.exceptions.ForbiddenRequestException;
import com.app.exceptions.UnauthorizedAccessException;
import com.app.pojos.Role;
import com.app.pojos.User;

import jakarta.servlet.http.HttpSession;
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
		if(userDTO.getRole().toUpperCase().equals(Role.ADMIN.toString())) {
			Long adminCount = userRepo.countByRole(Role.ADMIN);
			if(adminCount > 0) {
				System.out.println("unAuthorized Role creation ");
				throw new UnauthorizedAccessException("UnAuthorized role creation");
			}
		}
		try {
			User user = modelMapper.map(userDTO, User.class);
			user.setRole(Role.valueOf(userDTO.getRole().toUpperCase()));
			userRepo.save(user);
			UserIdDTO userIdDTO = modelMapper.map(user, UserIdDTO.class);
			System.out.println("UserIdDTO from UserServiceImpl"+userIdDTO);
			return userIdDTO;
		} catch (DataIntegrityViolationException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			throw new DuplicateEmailException("Email already exists");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("An unexpected error occurred");
		}
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
		throw new UnauthorizedAccessException("Please verify your credentials");
	}
	public String deleteUser(HttpSession session) {
		// TODO Auto-generated method stub
		User user = (User) session.getAttribute("currentUser");
		if(user == null) {
			throw new BadRequestException("you must login  first");
		}
		else if(user.getRole().toString().equals("ADMIN")) {
			throw new ForbiddenRequestException("Admin  cant delete themselves");
		}
		userRepo.deleteById(user.getId());
		return "User Deleted";
	}

}

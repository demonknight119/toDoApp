package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByRole(Role USER);

	User findByEmail(String email);
	
}

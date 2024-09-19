package com.app.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	private Long id;

	@Column(name = "user_Name", nullable = false)
	@NotBlank(message = "Name cannot be null")
	private String name;

	@Column(name = "password", nullable = false)
	@NotBlank(message = "password cannot be blank")
	@Size(min = 8, max = 30, message = "Password must be of length greater than  8 and less than 30")
	//@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,20}$", message = "Password must contain at least one letter, one number, and one special character")
	private String password;

	@Column(name = "email", nullable = false, unique = true)
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email should be valid")
	private String email;
	
	@Column(name = "Role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Task> tasks;

	/*
	 * =================Getter and Setters==========================================
	 */
	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	/* =================Constructor========================================== */

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(
				@NotBlank(message = "Name cannot be null") 
				String name,
				@NotBlank(message = "password cannot be blank")
				@Size(min = 8, max = 30, message = "Password must be of length greater than  8 and less than 30") 
				@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,20}$", message = "Password must contain at least one letter, one number, and one special character") 	
				String password,
				@NotBlank(message = "Email cannot be blank") 
				@Email(message = "Email should be valid") 
				String email,
				Role role) {
				super();
				this.name = name;
				this.password = password;
				this.email = email;
				this.role = role;
				}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", role=" + role
				+  "]";
	}
	

}

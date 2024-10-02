package com.app.dto;

import com.app.pojos.Role;

public class UserIdDTO {
	private Long id;
	private String name;
	private String email;
	private Role role;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
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
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserIdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserIdDTO(Long id, String name, String email, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserIdDTO [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
	
	
	
}

package com.app.dto;

public class LoginRequestDTO {
	private String email;
	private String role;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LoginRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginRequestDTO(String email, String role, String password) {
		super();
		this.email = email;
		this.role = role;
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequestDTO [email=" + email + ", role=" + role + "]";
	}
}

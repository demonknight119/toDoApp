package com.app.dto;

public class UserIdDTO {
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public UserIdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserIdDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserIdDTO [id=" + id + ", name=" + name + "]";
	}
	
	
}

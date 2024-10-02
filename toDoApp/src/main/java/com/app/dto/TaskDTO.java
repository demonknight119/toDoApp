package com.app.dto;

public class TaskDTO {
	
	private String task;
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	
	public TaskDTO(String task) {
		super();
		this.task = task;
		
	}
	public TaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TaskDTO [task=" + task + "]";
	}
	
}

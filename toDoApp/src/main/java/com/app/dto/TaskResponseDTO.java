package com.app.dto;

public class TaskResponseDTO {
		
	private String task;
	private Boolean status ;
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public TaskResponseDTO(String task, Boolean status) {
		super();
		this.task = task;
		this.status = status;
	}
	public TaskResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TaskResponseDTO [task=" + task + ", status=" + status + "]";
	}

}

package com.app.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	Long id;
	
	@Column(name = "task")
	String task;
	
	@Column(name = "task_status", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	Boolean status ;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_Id")
	User user;

	public String getTask() {
		return task;
	}

	public Long getId() {
		return id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(String task, User user) {
		super();
		this.task = task;
		this.status = false;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", status=" + status +"]";
	}
	
}

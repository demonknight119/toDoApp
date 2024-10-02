package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TaskRepository;
import com.app.dto.TaskDTO;
import com.app.dto.TaskResponseDTO;
import com.app.pojos.Task;
import com.app.pojos.User;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskRepo;
	
	@Autowired
	ModelMapper modelMapper;

	public TaskResponseDTO addTask(User currentUser, TaskDTO taskDTO) {
		// TODO Auto-generated method stub
		Task  newTask = modelMapper.map(taskDTO, Task.class);
		newTask.setUser(currentUser);
		newTask.setStatus(false);
		taskRepo.save(newTask);
		TaskResponseDTO taskResponse = modelMapper.map(newTask, TaskResponseDTO.class);
		return  taskResponse;
	}

}

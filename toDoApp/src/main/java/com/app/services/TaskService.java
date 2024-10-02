package com.app.services;

import com.app.dto.TaskDTO;
import com.app.dto.TaskResponseDTO;
import com.app.pojos.User;

public interface TaskService {
	TaskResponseDTO addTask(User currentUser, TaskDTO taskDTO);
}

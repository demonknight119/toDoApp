package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

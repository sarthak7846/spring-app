package com.examly.springapp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, String>{

}
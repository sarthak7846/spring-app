package com.examly.springapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskRepository;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    //Get All Tasks
    @GetMapping("/alltasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    //Get Task by ID
    @GetMapping("/getTask")
    public Task getTaskByHolderName(@RequestParam String taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        return taskOptional.get();
    }

    //Save a Task
    @PostMapping("/saveTask")
    public @ResponseBody String saveTask(@RequestBody Task task) {
        taskRepository.save(task);
        return "New task saved";
    }

    //Change task status
    @PutMapping("/changeStatus")
    public ResponseEntity<Task> changeStatus(@RequestParam String taskId) {
        Task updateTask = taskRepository.findById(taskId).orElseThrow(
            ()-> new ResourceNotFoundException("Task not exist with id: "));
        

        updateTask.setTaskStatus("Completed");
        taskRepository.save(updateTask);

        return ResponseEntity.ok(updateTask);
    }

    //Delete a task
    @DeleteMapping("/deleteTask")
    public String deleteTask(@RequestParam String taskId) {
        Task deleteTask = taskRepository.findById(taskId).orElseThrow(
            ()-> new ResourceNotFoundException("Task not exist with id: "));
        

        taskRepository.deleteById(deleteTask.getTaskID());
        return "Task deleted";
    }

}
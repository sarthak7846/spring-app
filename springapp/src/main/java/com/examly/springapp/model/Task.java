package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
    private String taskID;
    private String taskHolderName;
    private String taskDate;
    private String taskName;
    private String taskStatus;

	@Id
    public String getTaskID() {
		return taskID;
	}

	public String getTaskHolderName() {
		return taskHolderName;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskID(String taskID) {
		// int taskIdInt = Integer.parseInt(taskID);
		// this.taskID = taskIdInt;
		this.taskID=taskID;
	}

	public void setTaskHolderName(String taskHolderName) {
		this.taskHolderName = taskHolderName;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}	
}
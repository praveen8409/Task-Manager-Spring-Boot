package com.praveen.taskManager.entity;

import lombok.*;

import java.util.Date;
import java.util.List;


@Data
public class TaskEntity {

    private int id; // Unique identifier for the task.
    private String title; // Title of the task.
    private String desc; // Description or details of the task.
    private Date deadline;  // The date by which the task needs to be completed.
    private Boolean status;  // Represents the completion status of the task (true for completed, false for not completed).

}

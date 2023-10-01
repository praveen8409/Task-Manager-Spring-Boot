package com.praveen.taskManager.entity;

import lombok.*;

import java.util.Date;
import java.util.List;


@Data
public class TaskEntity {

    private int id;
    private String title;
    private String desc;
    private Date deadline;
    private Boolean status;

}

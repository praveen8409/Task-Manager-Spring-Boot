package com.praveen.taskManager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateTaskDTO {

    private String title;
    private  String desc;
    private String deadline;

}

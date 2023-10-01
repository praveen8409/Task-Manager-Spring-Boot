package com.praveen.taskManager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateTaskDTO {

    private String desc;
    private String deadline;
    private Boolean status;
}

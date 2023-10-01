package com.praveen.taskManager.dto;

import com.praveen.taskManager.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {

    private int id;
    private String title;
    private String desc;
    private Date deadline;
    private boolean status;
    private List<NoteEntity> notes;
}

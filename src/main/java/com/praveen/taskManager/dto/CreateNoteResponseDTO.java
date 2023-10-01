package com.praveen.taskManager.dto;

import com.praveen.taskManager.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateNoteResponseDTO {

    private  int taskId;
    private NoteEntity note;
}

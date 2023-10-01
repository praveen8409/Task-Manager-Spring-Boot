package com.praveen.taskManager.entity;

import lombok.Data;

@Data
public class NoteEntity {

    private int id;  // Unique identifier for the note.
    private String title;   // Title of the note.
    private String body;   // The content or body of the note.
}

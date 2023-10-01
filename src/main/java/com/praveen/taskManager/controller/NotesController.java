package com.praveen.taskManager.controller;

import com.praveen.taskManager.dto.CreateNoteDTO;
import com.praveen.taskManager.dto.CreateNoteResponseDTO;
import com.praveen.taskManager.entity.NoteEntity;
import com.praveen.taskManager.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    /**
     * Retrieve a list of notes associated with a specific task.
     *
     * @param taskId The ID of the task for which notes are requested.
     * @return ResponseEntity containing a list of NoteEntity objects and HTTP status OK.
     */
    @GetMapping
    public ResponseEntity<List<NoteEntity>> getAllNotes(@PathVariable("taskId") Integer taskId){
         var notes = noteService.getNotesForTask(taskId);
         return  new ResponseEntity<>(notes, HttpStatus.OK);
    }

    /**
     * Create a new note associated with a specific task.
     *
     * @param taskId The ID of the task to which the note is added.
     * @param body   The CreateNoteDTO object containing note details.
     * @return ResponseEntity containing a CreateNoteResponseDTO object with task and note details and HTTP status OK.
     */
    @PostMapping
    public ResponseEntity<CreateNoteResponseDTO> addNote(@PathVariable("taskId") Integer taskId, @RequestBody CreateNoteDTO body){
       var note = noteService.addNotesForTask(taskId, body.getTitle(), body.getBody());
        return new ResponseEntity<>(new CreateNoteResponseDTO(taskId,note),HttpStatus.OK);
    }
}

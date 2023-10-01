package com.praveen.taskManager.service;

import com.praveen.taskManager.entity.NoteEntity;
import com.praveen.taskManager.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private TaskService taskService;

    // HashMap to store notes associated with tasks
    HashMap<Integer,TaskNotesHolder > taskNotesHolders = new HashMap<>();

    // Inner class to hold task-specific notes and note ID
    class  TaskNotesHolder{
        protected int noteId = 1;
        protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }

    /**
     * Retrieves a list of notes associated with a specific task.
     *
     * @param taskId The ID of the task for which notes are requested.
     * @return A list of NoteEntity objects associated with the task, or null if the task does not exist.
     */

    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEntity task = taskService.getById(taskId);
        if(task == null){
            return  null;
        }

        if(taskNotesHolders.get(taskId) == null){
            taskNotesHolders.put(taskId, new TaskNotesHolder());
        }

        return taskNotesHolders.get(taskId).notes;
    }

    /**
     * Adds a new note to a specific task.
     *
     * @param taskId The ID of the task to which the note is added.
     * @param title  The title of the note.
     * @param body   The body content of the note.
     * @return The created NoteEntity, or null if the task does not exist.
     */
    public  NoteEntity addNotesForTask(int taskId, String title, String body){
        TaskEntity task = taskService.getById(taskId);
        if(task == null){
            return null;
        }
        // Create a TaskNotesHolder if it doesn't exist for the task
        if(taskNotesHolders.get(taskId) == null){
            taskNotesHolders.put(taskId, new TaskNotesHolder());
        }

        TaskNotesHolder taskNotesHolder = taskNotesHolders.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNotesHolder.noteId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.noteId++;
        return note;

    }
}

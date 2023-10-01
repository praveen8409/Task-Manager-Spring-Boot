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

    HashMap<Integer,TaskNotesHolder > taskNotesHolders = new HashMap<>();

    class  TaskNotesHolder{
        protected int noteId = 1;
        protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }

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

    public  NoteEntity addNotesForTask(int taskId, String title, String body){
        TaskEntity task = taskService.getById(taskId);
        if(task == null){
            return null;
        }

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

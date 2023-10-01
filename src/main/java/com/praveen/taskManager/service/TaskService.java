package com.praveen.taskManager.service;

import com.praveen.taskManager.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


@Service
public class TaskService {

    ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int id = 1;

    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");
     public TaskEntity addTask(String title, String desc, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(id);
        task.setTitle(title);
        task.setDesc(desc);
        task.setDeadline(deadlineFormatter.parse(deadline));
        task.setStatus(false);
        tasks.add(task);
        id++;
        return task;
    }


    public ArrayList<TaskEntity> getAllTask(){
         return  tasks;
    }

    public TaskEntity getById(int id){
         for(TaskEntity task : tasks){
             if(task.getId() == id){
                 return task;
             }
         }

         return  null;
    }
}
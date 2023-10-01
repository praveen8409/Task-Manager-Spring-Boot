package com.praveen.taskManager.service;

import com.praveen.taskManager.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


@Service
public class TaskService {

    // Store tasks in an ArrayList
    ArrayList<TaskEntity> tasks = new ArrayList<>();

    // Initialize the ID counter
    private int id = 1;

    // Date formatter for parsing deadlines
    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Adds a new task to the list of tasks.
     *
     * title    The title of the task.
     *  desc     The description of the task.
     *  deadline The deadline for the task in "yyyy-MM-dd" format.
     * The created TaskEntity.
     * ParseException if the deadline cannot be parsed.
     */
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

    /**
     * Retrieves a list of all tasks.
     *
     * @return An ArrayList containing all tasks.
     */

    public ArrayList<TaskEntity> getAllTask(){
         return  tasks;
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param id The ID of the task to retrieve.
     * @return The TaskEntity with the specified ID, or null if not found.
     */
    public TaskEntity getById(int id){
         for(TaskEntity task : tasks){
             if(task.getId() == id){
                 return task;
             }
         }

         return  null;
    }

    /**
     * Updates a task's description, deadline, and status.
     *
     *  id       The ID of the task to update.
     *  desc     The new description (or null to keep the existing description).
     *  deadline The new deadline in "yyyy-MM-dd" format (or null to keep the existing deadline).
     *  status   The new status (or null to keep the existing status).
     * @return The updated TaskEntity, or null if the task with the specified ID is not found.
     * @throws ParseException if the deadline cannot be parsed.
     */

    public TaskEntity updateTask(int id, String desc, String deadline, Boolean status) throws ParseException {
        TaskEntity task = getById(id);

        if(task == null){
            return  null;
        }

        if(desc != null){
            task.setDesc(desc);
        }
        if(deadline != null){
            task.setDeadline(deadlineFormatter.parse(deadline));
        }

        if(status != null){
            task.setStatus(status);
        }

        return task;
    }


}

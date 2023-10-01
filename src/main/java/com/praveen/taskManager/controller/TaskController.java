package com.praveen.taskManager.controller;

import com.praveen.taskManager.dto.TaskDTO;
import com.praveen.taskManager.entity.TaskEntity;
import com.praveen.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private  TaskService taskService;
//    public TaskController(TaskService taskService){
//        this.taskService = taskService;
//    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getAllTask(){
        return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<TaskEntity> getById(@PathVariable("id") Integer id){
        TaskEntity task = taskService.getById(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(task,HttpStatus.FOUND);
    }

    @PostMapping
    public  ResponseEntity<TaskEntity> addTask(@RequestBody TaskDTO body) throws ParseException {
        TaskEntity task = taskService.addTask(body.getTitle(), body.getDesc(), body.getDeadline());

        return new ResponseEntity<>(task,HttpStatus.OK);
    }
}

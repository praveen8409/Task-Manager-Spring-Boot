package com.praveen.taskManager.controller;

import com.praveen.taskManager.dto.CreateTaskDTO;
import com.praveen.taskManager.dto.TaskResponseDTO;
import com.praveen.taskManager.dto.UpdateTaskDTO;
import com.praveen.taskManager.entity.TaskEntity;
import com.praveen.taskManager.service.NoteService;
import com.praveen.taskManager.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private  TaskService taskService;
//    public TaskController(TaskService taskService){
//        this.taskService = taskService;
//    }

    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getAllTask(){
        return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<TaskResponseDTO> getById(@PathVariable("id") Integer id){
        TaskEntity task = taskService.getById(id);
        var notes = noteService.getNotesForTask(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }

        var taskResponse = modelMapper.map(task, TaskResponseDTO.class);
        taskResponse.setNotes(notes);
        return new ResponseEntity<>(taskResponse,HttpStatus.FOUND);
    }

    @PostMapping
    public  ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        TaskEntity task = taskService.addTask(body.getTitle(), body.getDesc(), body.getDeadline());

        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO body) throws ParseException {
       TaskEntity task = taskService.updateTask(id,body.getDesc(), body.getDeadline(), body.getStatus());
        if(task == null){
            return ResponseEntity.notFound().build();
        }
       return new ResponseEntity<>(task,HttpStatus.OK);
    }


}

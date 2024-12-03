package com.training.api.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.api.training.models.Task;
import com.training.api.training.services.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<?> getAllTasks(@RequestParam(value = "name", defaultValue = "") String name) {
        if (name.isEmpty()){
            return ResponseEntity.ok(taskService.getAllTask());
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskByName(name));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTask(@PathVariable Long id){
        Optional<Task> task = taskService.getTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/completed")
    public ResponseEntity<?> getAllTasksComplete() {
        return ResponseEntity.ok(taskService.getAllTaskCompleted());
    }

    @GetMapping("/incompleted")
    public ResponseEntity<?> getAllTasksInComplete() {
        List<Task> tasks = taskService.getAllTaskInCompleted();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }


    @PostMapping("/")
    public ResponseEntity<?> createTask(@Valid @RequestBody Task task){
        Task newTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @Valid @RequestBody Task data){
        Optional<Task> task = taskService.updateTask(id, data);
        if(task.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        if(taskService.deleteTask(id)){
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task Not Found");
        
    }
}

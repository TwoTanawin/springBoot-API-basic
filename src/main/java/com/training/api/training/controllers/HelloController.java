package com.training.api.training.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.training.api.training.models.Task;

@RestController
@RequestMapping("api/v1/hello")
public class HelloController {
    
    @GetMapping("/")
    public ResponseEntity<?> hello(@RequestParam(value = "name", defaultValue = "Spring-Boot") String name) {
        return ResponseEntity.status(HttpStatus.OK).body("Hello World Spring Boot " + name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> helloGetById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Hello Java Id: " + id);
    }

    // Create task
    @PostMapping("/")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        System.out.println("id : "+task.getId());
        System.out.println("name : "+task.getName());
        System.out.println("description : "+task.getDescription());
        System.out.println("id : "+task.getCompleated());
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
}

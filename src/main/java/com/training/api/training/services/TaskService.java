package com.training.api.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.api.training.models.Task;
import com.training.api.training.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return (List<Task>) taskRepository.findAll();
    }

    public List<Task> getAllTaskCompleted(){
        return (List<Task>) taskRepository.findBycompleatedTrue();
    }

    public List<Task> getAllTaskInCompleted(){
        return (List<Task>) taskRepository.findBycompleatedFalse();
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public List<Task> getTaskByName(String name){
        return (List<Task>) taskRepository.findByNameIsContaining(name);
    }

    public Optional<Task> updateTask(Long id, Task task){
        Optional<Task> getTask = taskRepository.findById(id);
        if(getTask.isEmpty())
        {
            return getTask;
        }
        task.setId(id);
        return Optional.of(taskRepository.save(task));
    }

    public boolean deleteTask(Long id){
        Optional<Task> getTask = taskRepository.findById(id);
        if(getTask.isEmpty())
        {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }
}

package com.training.api.training.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.api.training.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

    // public List<Task> findAll();
    public List<Task> findBycompleatedTrue();
    public List<Task> findBycompleatedFalse();
    public List<Task> findByNameIsContaining(String name);
}

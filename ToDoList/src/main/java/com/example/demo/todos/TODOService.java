package com.example.demo.todos;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TODOService {
    // Implements the (TODORepository) logic

    @Autowired // pulls in the repository
    private TODORepository todoRepository;

    public TODOService(TODORepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    // Get all TODOs
    public List<TODO> getAllTODOs() {
        return this.todoRepository.findAll();
    }

    // Get a todo by its id
    public TODO getTODOById(Long id) throws NoSuchElementException {
        return this.todoRepository.findById(id).orElseThrow();
    }

    // Create and save a new or existing todo
    public TODO createTODO(TODO todo) throws IllegalArgumentException, ObjectOptimisticLockingFailureException {
        return this.todoRepository.save(todo);
    }

    // Update a todo by its id
    public TODO updateTODO(Long id, TODO todo) throws NoSuchElementException {
        return this.todoRepository.save(todo);
      }
    
      public void deleteTODO(Long id) {
        this.todoRepository.delete(getTODOById(id));
      }
}

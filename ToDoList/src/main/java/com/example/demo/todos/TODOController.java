package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.TODO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/todos")

public class TODOController {
    // Handles HTTP requests and maps them to the corresponding service methods
    private TODOService todoService;

    public TODOController(TODOService todoService) {
      this.todoService = todoService;
    }

    // Retrieve a list of all TODOs
    @GetMapping()
    public List<TODO> getAllTODOs() {
    return todoService.getAllTODOs();
    }

    // Retrieve a specific Todo by its ID
    @GetMapping("/{id}")
    public ResponseEntity<TODO> getTODOById(@PathVariable Long id) {
        try {
            TODO todo = todoService.getTODO(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    // Create a new Todo
    @PostMapping()
    public ResponseEntity<TODO> createTodo(@RequestBody TODO todo) {
        TODO createdTodo = todoService.createTODO(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    // Update an existing Todo by its ID
    @PutMapping(path = "/{id}")
    public ResponseEntity<TODO> updateTodo(@PathVariable Long id, @RequestBody TODO todo) {
        try {
        TODO existingTodo = todoService.updateTODO(id, todo);
        return new ResponseEntity<>(existingTodo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an existing Todo by its ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        try {
            todoService.deleteTODO(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
package com.example.demo.todos;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


/** 
 * Interface that extends ListCrudRepository:
 * Access logic from service, and interact with the database,
 * using ListCrudRepository which returns a list.
 */ 

@Repository
public interface TODORepository extends ListCrudRepository<TODO, Long> {
}

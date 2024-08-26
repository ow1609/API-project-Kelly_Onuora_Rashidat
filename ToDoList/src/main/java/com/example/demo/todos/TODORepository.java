package com.example.demo;


import org.springframework.data.repository.ListCrudRepository;


/** 
 * Interface that extends ListCrudRepository:
 * Access logic from service, and interact with the database,
 * using ListCrudRepository which returns a list.
 */ 
public interface TODORepository extends ListCrudRepository<TODO, Long> {
}

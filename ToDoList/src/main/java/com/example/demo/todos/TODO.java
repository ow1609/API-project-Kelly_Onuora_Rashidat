package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;

 // Model that speaks to the database
@Entity
@Table(name = "todos")

public class TODO {

    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean taskCompleted;

    // constructors
    public TODO() {
        this(null, null, false);
    }

    public TODO(String title, String description, boolean taskCompleted) {
        // this.id = id;
        this.title = title;
        this.description = description;
        this.taskCompleted = taskCompleted;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean getTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }
}

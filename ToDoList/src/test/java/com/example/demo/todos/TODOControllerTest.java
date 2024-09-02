package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.Mock;
import org.springframework.context.annotation.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TODOControllerTest {

    @Mock // Create and mock instance of TODOService
    private TODOService todoService;

    // Inject the mocked instance of TODOService into the TODOController
    @InjectMocks 
    private TODOController todoController;

    @Test
    @Description("GET /api/todos - gets all TODOs")
    void getAllTODOs() {
        // Arrange
        List<TODO> mockTodo = Arrays.asList(
            
            new TODO("CBF intro to java", "Learn about Java", false),
            new TODO("CBF intro Spring Boot", "Learn about Spring", true),
            new TODO("CBF intro to REST-API", "Learn about REST", false));
            
        
        when(todoService.getAllTODOs()).thenReturn(mockTodo);

        // Act
        List<TODO> todoOutput = todoController.getAllTODOs();

        // Assert
        assertEquals(todoOutput.size(), mockTodo.size());
        verify(todoService).getAllTODOs();
    }
}

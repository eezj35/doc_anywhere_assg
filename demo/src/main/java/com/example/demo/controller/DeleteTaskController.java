package com.example.demo.controller;

import com.example.demo.exceptions.InvalidIdException;
import com.example.demo.service.DeleteTaskService;
import com.example.demo.service.UpdateTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteTaskController {
    private static final Logger logger = LoggerFactory.getLogger(com.example.demo.controller.GetTaskController.class);

    @Autowired
    private DeleteTaskService deleteTaskService;


    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(deleteTaskService.deleteTask(id));
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

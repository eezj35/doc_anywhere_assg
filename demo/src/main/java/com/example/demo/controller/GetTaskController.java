package com.example.demo.controller;

import com.example.demo.db.Database;
import com.example.demo.exceptions.InvalidIdException;
import com.example.demo.model.Task;
import com.example.demo.service.GetTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GetTaskController {

    private static final Logger logger = LoggerFactory.getLogger(GetTaskController.class);

    @Autowired
    private GetTaskService getTaskService;


    @GetMapping("/tasks")
    public ResponseEntity<ArrayList<Task>> getTasks() {
        return ResponseEntity.ok().body(getTaskService.getTask());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getSpecificTask(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(getTaskService.getSpecificTask(id));
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

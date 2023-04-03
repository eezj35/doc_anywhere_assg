package com.example.demo.controller;

import com.example.demo.db.Database;
import com.example.demo.exceptions.InvalidIdException;
import com.example.demo.model.Task;
import com.example.demo.service.CreateTaskService;
import com.example.demo.service.GetTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CreateTaskController {
    private static final Logger logger = LoggerFactory.getLogger(com.example.demo.controller.GetTaskController.class);

    @Autowired
    private CreateTaskService createTaskService;

    private Database db = Database.db;


    @PostMapping("/tasks")
    public ResponseEntity<String> createTask(@RequestParam String title,
                                             @RequestParam String description,
                                             @RequestParam Boolean completed) {
        return ResponseEntity.ok().body(createTaskService.createTask(title, description, completed));
    }



}

package com.example.demo.service;

import com.example.demo.db.Database;
import com.example.demo.exceptions.InvalidIdException;
import com.example.demo.model.Task;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService {
    Database db = Database.db;

    public String createTask(String title, String description, Boolean completed) {
        Task task = new Task(Long.valueOf(db.getTasks().size()), title, description, completed);
        db.getTasks().add(task);
        return "Created Task -> " + task.toString();
    }


}

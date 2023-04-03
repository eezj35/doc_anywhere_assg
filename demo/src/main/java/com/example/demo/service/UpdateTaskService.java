package com.example.demo.service;

import com.example.demo.db.Database;
import com.example.demo.exceptions.InvalidIdException;
import com.example.demo.model.Task;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UpdateTaskService {
    Database db = Database.db;

    public ArrayList<Task> getTask() {
        return db.getTasks();
    }

    public String updateTask(Long id,
                           @Nullable String title,
                           @Nullable String description,
                           @Nullable Boolean completed) throws InvalidIdException {
        if (db.getTasks().size() <= id || id < 0) {
            throw new InvalidIdException("Invalid ID!");
        }

        Task taskToUpdate = db.getTasks().get(id.intValue());
        if (title != null) {
            taskToUpdate.setTitle(title);
        }
        if (description != null) {
            taskToUpdate.setDescription(description);
        }
        if (completed != null) {
            taskToUpdate.setCompleted(completed);
        }

        return "Task updated -> " + taskToUpdate.toString();

    }
}

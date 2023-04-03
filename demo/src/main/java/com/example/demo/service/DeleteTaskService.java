package com.example.demo.service;

import com.example.demo.db.Database;
import com.example.demo.exceptions.InvalidIdException;
import com.example.demo.model.Task;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskService {
    Database db = Database.db;

    public String deleteTask(Long id) throws InvalidIdException {
        if (db.getTasks().size() <= id || id < 0) {
            throw new InvalidIdException("Invalid ID! ID does not exist in database; Delete operation aborted.");
        }
        Task taskToDelete = db.getTasks().remove(id.intValue());
        return ">>> Task deleted: " + taskToDelete.toString();
    }
}

package com.example.demo.service;

import com.example.demo.db.Database;
import com.example.demo.exceptions.InvalidIdException;
import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class GetTaskService {

    Database db = Database.db;

    public ArrayList<Task> getTask() {
        return db.getTasks();
    }

    public Task getSpecificTask(Long id) throws InvalidIdException {
        if (db.getTasks().size() <= id || id < 0) {
            throw new InvalidIdException("Invalid ID!");
        }
        return db.getTasks().get(id.intValue());
    }
}

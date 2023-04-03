package com.example.demo.db;

import com.example.demo.model.Task;

import java.util.ArrayList;

public class Database {
    private ArrayList<Task> tasks = new ArrayList<>();
    public static Database db = new Database();

    private Database() {
        tasks.add(new Task(Long.valueOf(1), "test", "test", true));
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

}

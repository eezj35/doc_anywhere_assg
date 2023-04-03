package com.example.demo.db;

import com.example.demo.model.Task;

import java.util.ArrayList;

public class Database {
    private ArrayList<Task> tasks = new ArrayList<>();
    public static Database db = new Database();

    private Database() {
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

}

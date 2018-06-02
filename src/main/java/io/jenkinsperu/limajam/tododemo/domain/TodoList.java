package io.jenkinsperu.limajam.tododemo.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoList {

    private List<Task> list;

    public TodoList() {
        this.list =  new ArrayList<>();
    }

    public void addTask(Task task){
        list.add(task);

    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public List<Task> getList() {
        return list;
    }
}

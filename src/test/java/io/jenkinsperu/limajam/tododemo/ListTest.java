package io.jenkinsperu.limajam.tododemo;

import io.jenkinsperu.limajam.tododemo.domain.Task;
import io.jenkinsperu.limajam.tododemo.domain.TodoList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void testAddTask(){

        TodoList todoList = new TodoList();

        todoList.addTask(new Task("hacer tests"));
        assertFalse(todoList.isEmpty());
        assertEquals(1,todoList.getSize() );

    }

    @Test
    public void testMarkAsDone(){

        Task task = new Task("task 1");

        task.done();

        assertTrue(task.isDone());

    }

    @Test
    public void testGetTaskList(){

        TodoList todoList = new TodoList();
        todoList.addTask(new Task("hacer tests"));

        List<Task> taskList= new ArrayList<>();
        taskList.add(new Task("hacer tests"));

        assertEquals(taskList,todoList.getList());



    }
}

package io.jenkinsperu.limajam.tododemo.controller;

import io.jenkinsperu.limajam.tododemo.domain.Task;
import io.jenkinsperu.limajam.tododemo.domain.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {

    @Autowired
    TodoList todoList;

    @GetMapping("/index")
    public String index(@RequestParam(name="texto", required=false) String name, Model model) {


        if(!name.isEmpty()){
            todoList.addTask(new Task(name));
        }

        model.addAttribute("tasks",todoList.getList());




        return "index";
    }
}

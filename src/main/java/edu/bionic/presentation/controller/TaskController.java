package edu.bionic.presentation.controller;

import edu.bionic.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by denis on 29.08.17.
 */
@Controller
@RequestMapping("projects/{projectId}/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String showTasks(Model model) {;
        model.addAttribute("tasks", taskService.getAll());
        return "project/project-list";
    }
}

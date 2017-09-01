package edu.bionic.presentation.controller;

import edu.bionic.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by denis on 29.08.17.
 */
@Controller
@RequestMapping("projects/{projectId}/task/{taskId}")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String showTask(Model model, @PathVariable("taskId") Integer taskId) {;
        model.addAttribute("task", taskService.getById(taskId));
        return "project/task/task";
    }
}

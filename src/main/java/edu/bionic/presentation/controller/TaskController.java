package edu.bionic.presentation.controller;

import edu.bionic.domain.Project;
import edu.bionic.domain.Task;
import edu.bionic.domain.User;
import edu.bionic.dto.LoggedUser;
import edu.bionic.service.ProjectService;
import edu.bionic.service.TaskService;
import edu.bionic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by denis on 29.08.17.
 */
@Controller
@RequestMapping("projects/{projectId}/tasks")
public class TaskController {

    private TaskService taskService;
    private UserService userService;
    private ProjectService projectService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService, ProjectService projectService) {
        this.taskService = taskService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("{taskId}")
    public String showTask(Model model, @PathVariable("taskId") Integer taskId) {;
        model.addAttribute("task", taskService.getById(taskId));
        return "project/task/task";
    }

    @GetMapping("{taskId}/edit")
    public String editTaskPage(@PathVariable("taskId") Integer taskId, Model model) {
        model.addAttribute("task", taskService.getById(taskId));
        return "project/task/task-edit";
    }

    @PostMapping("{taskId}/edit")
    public String editTask(@Valid @ModelAttribute Task task,
                              BindingResult bindingResult,
                              @PathVariable("taskId") Integer taskId,
                              RedirectAttributes redirectAttributes) {
        if  (bindingResult.hasErrors()) {
            return "admin/project-edit";
        }
        task.setId(taskId);
        taskService.update(task);
        redirectAttributes.addFlashAttribute("updateIsSuccessful", true);
        return "redirect:/projects/{projectId}/tasks/" + taskId;
    }

    @GetMapping("new")
    public String newTaskPage(@PathVariable("projectId") Integer projectId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoggedUser loggedUser = (LoggedUser) authentication.getPrincipal();

        model.addAttribute("user", loggedUser.getUser());
        model.addAttribute("project", projectService.getById(projectId));
        model.addAttribute("task", new Task());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("isNew", true);
        return "project/task/task-edit";
    }

    @PostMapping("new")
    public String editTask(@Valid @ModelAttribute Task task,
                              BindingResult bindingResult,
                              Model model) {
        if  (bindingResult.hasErrors()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            LoggedUser loggedUser = (LoggedUser) authentication.getPrincipal();
            model.addAttribute("isNew", true);
            model.addAttribute("users", userService.getAll());
            model.addAttribute("user", loggedUser.getUser());

            return "project/task/task-edit";
        }

        Task createdTask = taskService.create(task);
        return "redirect:/projects/{projectId}/tasks/" + createdTask.getId();
    }
}

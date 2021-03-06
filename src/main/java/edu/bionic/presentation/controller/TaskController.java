package edu.bionic.presentation.controller;

import edu.bionic.domain.Comment;
import edu.bionic.domain.Project;
import edu.bionic.domain.Task;
import edu.bionic.domain.User;
import edu.bionic.dto.LoggedUser;
import edu.bionic.service.CommentService;
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
import java.time.format.DateTimeFormatter;

/**
 * Created by denis on 29.08.17.
 */
@Controller
@RequestMapping("projects/{projectId}/tasks")
public class TaskController {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");

    private TaskService taskService;
    private UserService userService;
    private ProjectService projectService;
    private CommentService commentService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService, ProjectService projectService,
                          CommentService commentService) {
        this.taskService = taskService;
        this.userService = userService;
        this.projectService = projectService;
        this.commentService = commentService;
    }

    @GetMapping("{taskId}")
    public String showTask(Model model, @PathVariable("taskId") Integer taskId) {
        model.addAttribute("user", userService.getAuthenticatedUser().get());
        model.addAttribute("comments", commentService.getByTask(taskId));
        if (!model.containsAttribute("newComment")) {
            model.addAttribute("newComment", new Comment());
        }
        model.addAttribute("task", taskService.getById(taskId));
        model.addAttribute("dateTimeFormatter", dateTimeFormatter);
        return "project/task/task";
    }

    @PostMapping("{taskId}")
    public String showTaskWithEditedStatus(@Valid @ModelAttribute Task task,
                                           @PathVariable("taskId") Integer taskId,
                                           RedirectAttributes redirectAttributes, Model model) {
        task.setId(taskId);
        taskService.update(task);
        return "redirect:/projects/{projectId}/tasks/" + taskId;
    }

    @GetMapping("mytasks")
    public String showTaskByUserId(Model model, @PathVariable("projectId") Integer projectId) {
        User currentUser = userService.getAuthenticatedUser().get();

        model.addAttribute("user", currentUser);
        model.addAttribute("project", projectService.getById(projectId));
        model.addAttribute("tasks", taskService.getByUserId(currentUser.getId(), projectId));
        return "project/task/task-list";
    }

    @GetMapping("{taskId}/edit")
    public String editTaskPage(@PathVariable("taskId") Integer taskId, Model model) {

        model.addAttribute("user", userService.getAuthenticatedUser().get());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("task", taskService.getById(taskId));

        return "project/task/task-edit";
    }

    @PostMapping("{taskId}/edit")
    public String editTask(@Valid @ModelAttribute Task task,
                           BindingResult bindingResult,
                           @PathVariable("taskId") Integer taskId,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasErrors()) {

            model.addAttribute("user", userService.getAuthenticatedUser().get());
            model.addAttribute("users", userService.getAll());

            return "project/task/task-edit";
        }
        task.setId(taskId);
        taskService.update(task);
        redirectAttributes.addFlashAttribute("updateIsSuccessful", true);
        return "redirect:/projects/{projectId}/tasks/" + taskId + "/edit";
    }

    @GetMapping("new")
    public String newTaskPage(@PathVariable("projectId") Integer projectId, Model model) {
        model.addAttribute("user", userService.getAuthenticatedUser().get());
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
        if (bindingResult.hasErrors()) {
            model.addAttribute("isNew", true);
            model.addAttribute("users", userService.getAll());
            model.addAttribute("user", userService.getAuthenticatedUser().get());

            return "project/task/task-edit";
        }

        Task createdTask = taskService.create(task);
        return "redirect:/projects/{projectId}/tasks/" + createdTask.getId();
    }
}

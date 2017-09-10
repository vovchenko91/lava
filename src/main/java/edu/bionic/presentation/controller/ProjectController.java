package edu.bionic.presentation.controller;

import edu.bionic.dto.TaskSort;
import edu.bionic.service.ProjectService;
import edu.bionic.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

/**
 * Created by denis on 29.08.17.
 */
@Controller
@RequestMapping("projects")
public class ProjectController {

    private final int PAGE_SIZE = 3;

    private ProjectService projectService;
    private TaskService taskService;

    @Autowired
    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping
    public String showProjects(Model model) {;
        model.addAttribute("projects", projectService.getAll());
        return "project/project-list";
    }

    @GetMapping("{projectId}")
    public String showProject(Model model,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "assignee", required = false) String assignee,
                              @RequestParam(value = "sort", required = false) TaskSort sort,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @PathVariable("projectId") Integer projectId) {
        int offset = (page - 1) * PAGE_SIZE;
        int limit = PAGE_SIZE;
        if (sort == null) sort = TaskSort.NAME_ASC;
        model.addAttribute(projectService.getById(projectId));
        model.addAttribute("tasks", taskService.getAll(name, assignee, sort, offset, limit, projectId));
        model.addAttribute("taskCount", taskService.getCount(name, assignee, projectId));
        model.addAttribute("pageSize", PAGE_SIZE);
        return "project/project";
    }
}

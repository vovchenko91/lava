package edu.bionic.presentation.controller;

import edu.bionic.service.ProjectService;
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

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");
    private final int PAGE_SIZE = 5;

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
            this.projectService = projectService;
        }

    @GetMapping
    public String showProjects(Model model) {;
        model.addAttribute("projects", projectService.getAll());
        return "project/project-list";
    }

    @GetMapping("{projectId}")
    public String showProject(Model model,
                              @PathVariable("projectId") Integer projectId) {
        model.addAttribute(projectService.getById(projectId));

        return "project/project";
    }
}

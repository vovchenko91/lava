package edu.bionic.presentation.controller.admin;

import edu.bionic.domain.Project;
import edu.bionic.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by denis on 30.08.17.
 */
@Controller
@RequestMapping("admin/projects")
public class AdminProjectController {


    private ProjectService projectService;

    @Autowired
    public AdminProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String showProjects(Model model) {
        model.addAttribute("projects", projectService.getAll());
        return "admin/project-list";
    }

    @GetMapping("{projectId}")
    public String editProjectPage(@PathVariable("projectId") Integer projectId, Model model) {
        model.addAttribute("project", projectService.getById(projectId));
        return "admin/project-edit";
    }

    @PostMapping("{projectId}")
    public String editProject(@Valid @ModelAttribute Project project,
                              BindingResult bindingResult,
                              @PathVariable("projectId") Integer projectId,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/project-edit";
        }
        project.setId(projectId);
        projectService.update(project);
        redirectAttributes.addFlashAttribute("updateIsSuccessful", true);
        return "redirect:/admin/projects/";
    }

    @GetMapping("new")
    public String newProjectPage(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("isNew", true);
        return "admin/project-edit";
    }

    @PostMapping("new")
    public String editProject(@Valid @ModelAttribute Project project,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("isNew", true);
            return "admin/project-edit";
        }

        Project createdProject = projectService.create(project);
        return "redirect:/admin/projects/";
    }

    @PostMapping("{projectId}/delete")
    public String deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.delete(projectId);
        return "redirect:/admin/projects/";
    }
}

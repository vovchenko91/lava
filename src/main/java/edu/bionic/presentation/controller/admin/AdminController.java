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
@RequestMapping("admin")
public class AdminController {

    @Autowired
    public AdminController() {
    }

    @GetMapping
    public String showMenu() {
        return "admin/menu";
    }
}

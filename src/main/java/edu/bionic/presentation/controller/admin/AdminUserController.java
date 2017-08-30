package edu.bionic.presentation.controller.admin;

import edu.bionic.domain.Project;
import edu.bionic.domain.User;
import edu.bionic.service.ProjectService;
import edu.bionic.service.UserService;
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
@RequestMapping("admin/users")
public class AdminUserController {



    private UserService userService;

    @Autowired
    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin/user-list";
    }

    @GetMapping("{userId}")
    public String editUserPage(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("user", userService.getById(userId));
        return "admin/user-edit";
    }

    @PostMapping("{userId}")
    public String editUser(@Valid @ModelAttribute User user,
                              BindingResult bindingResult,
                              @PathVariable("userId") Integer userId,
                              RedirectAttributes redirectAttributes) {
        if  (bindingResult.hasErrors()) {
            return "admin/user-edit";
        }
        user.setId(userId);
        userService.update(user);
        redirectAttributes.addFlashAttribute("updateIsSuccessful", true);
        return "redirect:/admin/users/" + userId;
    }

    @GetMapping("new")
    public String newUserPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("isNew", true);
        return "admin/user-edit";
    }

    @PostMapping("new")
    public String editProject(@Valid @ModelAttribute User user,
                              BindingResult bindingResult,
                              Model model) {
        if  (bindingResult.hasErrors()) {
            model.addAttribute("isNew", true);
            return "admin/user-edit";
        }
        User createdUser = userService.create(user);
        return "redirect:/admin/users/" + createdUser.getId();
    }

    @PostMapping("{userId}/delete")
    public String deleteUser(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
        return "redirect:/admin/users/";
    }
}

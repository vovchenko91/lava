package edu.bionic.presentation.controller;

import edu.bionic.domain.Comment;
import edu.bionic.dto.LoggedUser;
import edu.bionic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by denis on 30.08.17.
 */
@Controller
@RequestMapping("comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String addNewComment(@Valid @ModelAttribute Comment comment,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoggedUser loggedUser = (LoggedUser) authentication.getPrincipal();

        model.addAttribute("user", loggedUser.getUser());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("newComment", comment);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.newComment", bindingResult);
        } else {
            commentService.createNew(comment);
        }
        return "redirect:/projects/" + comment.getTask().getProject().getId() + "/tasks/" + comment.getTask().getId();
    }
}

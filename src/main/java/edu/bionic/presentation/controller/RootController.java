package edu.bionic.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by denis on 30.08.17.
 */
@Controller
public class RootController {

    @GetMapping("/")
    public String showMainPage() {
        return "index";
    }
}

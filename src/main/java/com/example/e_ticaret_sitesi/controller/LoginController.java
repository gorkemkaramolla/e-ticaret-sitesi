package com.example.e_ticaret_sitesi.controller;

import com.example.e_ticaret_sitesi.util.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final SecurityUtils securityUtils;

    public LoginController(SecurityUtils securityUtils) {
        this.securityUtils = securityUtils;
    }

    @GetMapping("/giris")
    public String showLoginPage(RedirectAttributes redirectAttributes) {
        if (securityUtils.isUserLoggedIn()) {
            return "redirect:/";
        }

        return "giris";
    }
}

package com.app.vetClinicApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/")
    public String showUserHomePage() {
        return "homePage";
    }

    @GetMapping("/aboutus")
    public String showAboutUsPage() {
        return "aboutUsPage";
    }


    @GetMapping("/403")
    public String showError403Page() {
        return "403";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "loginPage";
    }
}

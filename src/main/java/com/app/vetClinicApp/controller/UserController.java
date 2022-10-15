package com.app.vetClinicApp.controller;

import com.app.vetClinicApp.model.entity.Role;
import com.app.vetClinicApp.model.entity.User;
import com.app.vetClinicApp.service.IRolesService;
import com.app.vetClinicApp.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    IUsersService userService;

    @Autowired
    IRolesService rolesService;

    @GetMapping("user/listusers")
    public String getAllUsers(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users",userList);
        return "user/userPage";
    }

    @GetMapping("/user/new")
    public String showNewUserPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        Set<Role> roles = this.rolesService.getAll();
        model.addAttribute("roleList",roles);
        return "user/newUserPage";
    }

    @PostMapping("user/save")
    public String saveUser(@ModelAttribute("user") User user){
        this.userService.saveUser(user);
        return "redirect:/user/listusers";
    }

}

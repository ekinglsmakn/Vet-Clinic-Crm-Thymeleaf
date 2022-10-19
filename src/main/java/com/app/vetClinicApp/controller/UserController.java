package com.app.vetClinicApp.controller;

import com.app.vetClinicApp.model.entity.Role;
import com.app.vetClinicApp.model.entity.User;
import com.app.vetClinicApp.service.IRolesService;
import com.app.vetClinicApp.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUsersService userService;

    @Autowired
    private IRolesService rolesService;

    @GetMapping("/user/listusers")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "user/userPage";
    }

    //used to delete user by id
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/user/listusers";

    }

    //this is the save method
    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute("user") User user) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String newPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        this.userService.saveUser(user); //save pet to dataBase
        return "redirect:/user/listusers";
    }

    //opens the form page for adding a new user
    @GetMapping("/user/new")
    public String showNewUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        List<Role> roles = this.rolesService.getAll();
        model.addAttribute("roleList", roles);
        return "user/newUserPage";
    }

}
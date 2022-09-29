package com.app.vetClinicApp.controller;

import com.app.vetClinicApp.model.entity.Pet;
import com.app.vetClinicApp.model.entity.PetOwner;
import com.app.vetClinicApp.service.IPetOwnerService;
import com.app.vetClinicApp.service.IPetService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Getter
@Setter
public class PetOwnerController {

    @Autowired
    private IPetOwnerService ownerService;

    @Autowired
    private IPetService iPetService;


    //thymeleaf methods

    // used to open new owner form page
    @GetMapping("/owner/new")
    public String showNewOwnerForm(Model model) {
        //creating model attribute and new PetOwner object to bind form data
        model.addAttribute("owner", new PetOwner());
        return "newOwnerPage";
    }

    // used for saving
    @PostMapping("/owner/save")
    public String saveOwner(@ModelAttribute("owner") PetOwner petOwner) {
        this.ownerService.save(petOwner);
        return "redirect:/ownerpage";
    }

    // used to open owner listing page
    @GetMapping("/ownerpage")
    public String listOwners(Model model) {
        model.addAttribute("listOfOwners", ownerService.getAll());
        return "ownerPage";
    }

    // used to open new owner form page for Update
    @GetMapping("/owners/edit/{id}")
    public String showEditOwnerForm(@PathVariable("id") Long id, Model model) {
        PetOwner owner = this.ownerService.getById(id);
        model.addAttribute("owner", owner);
        model.addAttribute("listOfPets", iPetService.getAllPets());
        return "newOwnerPage";

    }

    //used to open "owner detail form page" for examination table
    @GetMapping("/owners/detail/{id}")
    public String petOwnerDetail(@PathVariable("id") Long id, Model model) {

        PetOwner owner = this.ownerService.getById(id);
        model.addAttribute("owner", owner);
        model.addAttribute("listOfPets", iPetService.findPetsByPetOwnerId(id));
        return "ownerDetailPage";
    }


    @GetMapping("/owners/delete/{id}")
    public String deleteOwner(@PathVariable("id") Long id, Model model) {
        ownerService.deleteById(id);
        return "redirect:/ownerpage";
    }

}

package com.app.vetClinicApp.controller;

import com.app.vetClinicApp.model.entity.Pet;
import com.app.vetClinicApp.model.entity.PetOwner;
import com.app.vetClinicApp.service.IPetOwnerService;
import com.app.vetClinicApp.service.IPetService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Getter
@Setter

public class PetController {

    @Autowired
    private IPetService iPetService;
    @Autowired
    private IPetOwnerService ownerService;

//
//    @PostMapping("/savepet")
//    public Pet savePet(@RequestBody Pet pet) {
//        return this.iPetService.save(pet);
//    }

    @PutMapping("/updatepet")
    public void updatePet(@RequestBody Pet pet) {
        this.iPetService.update(pet);
    }

    @DeleteMapping("/deletePet/{id}")
    public void deletePet(@PathVariable Long id) {
        this.iPetService.delete(id);
    }

    @GetMapping("/getAllPet")
    public List<Pet> getAllPet(){
        return this.iPetService.getAllPets();
    }

    @GetMapping("/getAllByName/{name}")
    public List<Pet> getAllByName(@PathVariable String name){
        return this.iPetService.getPetsByName(name);
    }


//*********************************************************************************************************
    //thymeleaf methods

    @GetMapping("/petpage")
    public String getPets(Model model){
        model.addAttribute("listOfPets",iPetService.getAllPets());
        return "petPage"; //name of html page
    }

    @GetMapping("/petdetails")
    public String getPetsAll(Model model){
        model.addAttribute("listOfPets",iPetService.getAllPets());
        return "petDetailsPage"; //name of html page
    }

    @GetMapping("/shownewpetform")
    public String showNewPet(Model model){
        //creating mode attribute to bind form data
        Pet pet = new Pet();
        model.addAttribute("pet",pet);

        List<PetOwner> petOwnerList = ownerService.getAll();
        model.addAttribute("ownerList",petOwnerList);
        return "newPetPage";
    }

    @PostMapping("/savepet")
    public String savePet(@ModelAttribute("pet") Pet pet) {
        this.iPetService.save(pet); //save pet to dataBase
        return "redirect:/petpage";
    }

    // used to open new owner form page for update
    @GetMapping("/pets/edit/{id}")
    public String showEditPetForm(@PathVariable("id") Long id, Model model) {
        Pet pet = iPetService.getById(id);
        model.addAttribute("pet",pet);
        model.addAttribute("listOfOwner",ownerService.getAll());
        return "newPetPage";

    }



}

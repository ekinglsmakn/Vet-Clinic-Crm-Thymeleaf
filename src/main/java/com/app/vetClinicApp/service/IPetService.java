package com.app.vetClinicApp.service;

import com.app.vetClinicApp.model.entity.Pet;


import java.util.List;

public interface IPetService {
    Pet save(Pet pet);
    Pet update(Pet pet);
    void deleteById(Long id);
    List<Pet> getAllPets();
    List<Pet> getPetsByName(String name);
    List<Pet> findPetsByPetOwnerId(Long id);
    Pet getById(Long id);


}

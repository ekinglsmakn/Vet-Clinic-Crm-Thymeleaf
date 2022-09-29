package com.app.vetClinicApp.repository;

import com.app.vetClinicApp.model.entity.Pet;
import com.app.vetClinicApp.model.entity.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findPetByName(String name);

    List<Pet> findPetsByPetOwnerId(Long id);





}


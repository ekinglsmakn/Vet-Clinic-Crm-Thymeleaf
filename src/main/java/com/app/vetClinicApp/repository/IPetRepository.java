package com.app.vetClinicApp.repository;

import com.app.vetClinicApp.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetRepository extends JpaRepository<Pet,Long> {
    List<Pet> findPetByName(String name);
    List<Pet> findPetsByPetOwnerId(Long id);

}


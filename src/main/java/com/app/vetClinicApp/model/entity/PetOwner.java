package com.app.vetClinicApp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pet_owner")
@NamedEntityGraph(name = "PetOwner.detail", attributeNodes = @NamedAttributeNode("petList"))
public class PetOwner extends BaseEntity{
    private String name;
    private String surname;
    private Long phone;
    @Column(name = "e_mail")
    private String email;
    private String address;

    // Do not delete petOwner, when pet is deleted. Because 1 petOwner can have more than one pet
    @JsonIgnore
    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Pet> petList;  //one petOwner can have many pets

}

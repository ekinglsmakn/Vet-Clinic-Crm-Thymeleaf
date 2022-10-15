package com.app.vetClinicApp.repository;

import com.app.vetClinicApp.model.entity.Role;
import com.app.vetClinicApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {

    Set<Role> getRoleByUsers(@Param("user") User user);
}

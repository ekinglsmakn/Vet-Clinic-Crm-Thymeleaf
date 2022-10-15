package com.app.vetClinicApp.repository;

import com.app.vetClinicApp.model.entity.Role;
import com.app.vetClinicApp.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

    User getUsersByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.roles =: roles")
    List<User> findByRoles(@Param("roles") Role roles);
}

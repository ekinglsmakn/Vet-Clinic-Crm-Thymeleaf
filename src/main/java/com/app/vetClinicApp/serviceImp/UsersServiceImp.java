package com.app.vetClinicApp.serviceImp;

import com.app.vetClinicApp.model.entity.User;
import com.app.vetClinicApp.repository.IUserRepository;
import com.app.vetClinicApp.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImp implements IUsersService {

    @Autowired
    IUserRepository userRepository;

    @Transactional
    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}

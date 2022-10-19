package com.app.vetClinicApp.securityConfiguration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 *
 * This class encrypts password to save in database
 *
 * */
public class PasswordCreator {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//      String rawPassword= "admin123"; //username: admin (role:ADMIN)
        String rawPassword = "user123";  //username: ekin (role:USER)

        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}

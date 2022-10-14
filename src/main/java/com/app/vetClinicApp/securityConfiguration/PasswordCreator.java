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
//      String rawPassword= "secret";  //username: user (role: USER)
        String rawPassword = "java123";  //username: ekin (role:ADMIN and USER)

        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}

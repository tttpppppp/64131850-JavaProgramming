package com.cybersoft.projectcyber.service;

import com.cybersoft.projectcyber.entity.Users;
import com.cybersoft.projectcyber.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean checkloginUser(String email, String password) {
        Users user = userRepository.findByEmail(email);
        if(user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }
}

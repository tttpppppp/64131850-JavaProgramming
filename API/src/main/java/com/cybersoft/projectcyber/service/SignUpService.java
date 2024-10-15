package com.cybersoft.projectcyber.service;

import com.cybersoft.projectcyber.entity.Roles;
import com.cybersoft.projectcyber.entity.Users;
import com.cybersoft.projectcyber.payload.request.SignUpRequest;
import com.cybersoft.projectcyber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SignUpService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public boolean signUp(SignUpRequest signUpRequest) {
        if(userRepository.findByEmail(signUpRequest.getEmail()) != null){
            return false;
        }
        Users user = new Users();
        Roles role = new Roles();
        role.setRoleId(2);
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setFullName(signUpRequest.getFullname());
        user.setCreateDate(new Date());
        user.setRoles(role);
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}

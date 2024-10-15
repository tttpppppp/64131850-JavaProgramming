package com.cybersoft.projectcyber.service;

import com.cybersoft.projectcyber.dto.UserDTO;
import com.cybersoft.projectcyber.entity.Users;
import com.cybersoft.projectcyber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<Users> users = userRepository.findAll();
        List<UserDTO> listUserDTO = new ArrayList<>();
       for (Users user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setFullName(user.getFullName());
            userDTO.setPassword(user.getPassword());
            userDTO.setRolename(user.getRoles().getRoleName());
            listUserDTO.add(userDTO);
       }
       return listUserDTO;
    }
}

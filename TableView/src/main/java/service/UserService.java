package service;

import Repository.UserRepository;
import model.User;

import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();
    public List<User> getAllUsers() {
        return userRepository.getUsers();
    }
    public void addUser(User user) {
        userRepository.addUser(user);
    }
}

package com.ttida.service;

import com.ttida.model.UserTab;
import com.ttida.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
	@Autowired
    private UserRepository userRepository; 

    public void saveUser(UserTab user) {
        userRepository.save(user);
    }
    
    public boolean usernameExists(String username) {
        Optional<UserTab> existingUser = userRepository.findByUsername(username);
        return existingUser.isPresent();
    }
    
    public boolean validatePassword(String username, String enteredPassword) {
        Optional<UserTab> optionalUserTab = userRepository.findByUsername(username);

        if (optionalUserTab.isPresent()) {
            UserTab userTab = optionalUserTab.get();
            return userTab.validateEnteredPassword(enteredPassword);
        }

        return false;
    }
    public boolean validateCredentials(String username, String password) {
        Optional<UserTab> optionalUserTab = userRepository.findByUsername(username);

        return optionalUserTab.map(userTab -> userTab.getPassword().equals(password)).orElse(false);
    }

    public boolean validateUser(String username, String email) {
        Optional<UserTab> optionalUserTab = userRepository.findByUsername(username);

        return optionalUserTab.map(userTab -> userTab.getEmail().equals(email)).orElse(false);
    }
    

}

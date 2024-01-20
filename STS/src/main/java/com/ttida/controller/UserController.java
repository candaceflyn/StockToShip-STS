package com.ttida.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ttida.model.UserTab;
import com.ttida.repository.UserRepository;
import com.ttida.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository; 


    @CrossOrigin(origins = "http://localhost:4200/signup")
    @PostMapping("/save-user")
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody UserTab user) {
        try {
            userService.saveUser(user);
            Map<String, String> response = new HashMap<>();
            response.put("success", "true");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("success", "false");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PostMapping("/check-username")
    public ResponseEntity<Map<String, Boolean>> checkUsernameAvailability(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        boolean available = !userService.usernameExists(username);
        Map<String, Boolean> response = Collections.singletonMap("available", available);
        return ResponseEntity.ok(response);
    }
 
    @PostMapping("/validate-credentials")
    public ResponseEntity<Map<String, Boolean>> validateCredentials(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        boolean isValid = userService.validateCredentials(username, password);

        Map<String, Boolean> response = new HashMap<>();
        response.put("valid", isValid);

        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/validate-user")
    public ResponseEntity<Map<String, Boolean>> validateUser(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String email = credentials.get("email");

        boolean isValid = userService.validateUser(username, email);

        Map<String, Boolean> response = new HashMap<>();
        response.put("valid", isValid);

        return ResponseEntity.ok(response);
    }
    @PostMapping("/update-password")
    public ResponseEntity<Map<String, Object>> updatePassword(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String newPassword = request.get("password");

        Optional<UserTab> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            UserTab user = optionalUser.get();

            user.setPassword(newPassword);
            userRepository.save(user);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("error", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}

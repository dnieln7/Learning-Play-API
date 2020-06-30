package com.dnieln7.javaspringapi.controller;

import com.dnieln7.javaspringapi.controller.response.GenericResponse;
import com.dnieln7.javaspringapi.data.model.Login;
import com.dnieln7.javaspringapi.data.model.User;
import com.dnieln7.javaspringapi.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/login")
    public GenericResponse<User> login(@RequestBody Login login) {
        GenericResponse<User> response = new GenericResponse<>();

        List<User> result = userRepository.findByEmail(login.getEmail());

        if (!result.isEmpty()) {
            User user = result.get(0);

            if (user.getPassword().equals(login.getPassword()) && user.getRole().equals(login.getRole())) {
                response.setCode(1);
                response.setDescription("Login Successful");
                response.setResult(user);
            } else {
                response.setCode(0);
                response.setDescription("Wrong Credentials");
            }
        } else {
            response.setCode(0);
            response.setDescription("Email is not registered");
        }

        return response;
    }

    @PostMapping("/users/sign-up")
    public GenericResponse<User> signUp(@RequestBody User userIn) {
        GenericResponse<User> response = new GenericResponse<>();

        List<User> result = userRepository.findByEmail(userIn.getEmail());

        if (!result.isEmpty()) {
            response.setCode(0);
            response.setDescription("Email is already registered");
        } else {
            if (userIn.getRole().equals("TEACHER") || userIn.getRole().equals("STUDENT")) {
                User user = userRepository.save(userIn);

                response.setCode(1);
                response.setDescription("Sign Up successful");
                response.setResult(user);
            }
            else {
                response.setCode(1);
                response.setDescription("Role must be ADMIN or STUDENT");
            }
        }

        return response;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getFormById(@PathVariable int id) {
        return userRepository.findById(id).orElse(null);
    }
}

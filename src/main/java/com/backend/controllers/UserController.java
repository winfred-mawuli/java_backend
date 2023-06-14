package com.backend.controllers;


import com.backend.models.User;
import com.backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{userId}")
    public Optional<User> getUser(@PathVariable("userId") Integer userId) {
        return userService.getUser(userId);
    }


    @PostMapping
    public void registerNewMember(@Valid @RequestBody User user) {
        userService.addMember(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("{userId}")
    public void updateUser(
            @PathVariable("userId") Integer userId,
            @RequestBody(required = false) String name,
            @RequestBody(required = false) String email,
            @RequestBody(required = false) String password
    ) {
        userService.updateUser(userId, name, email, password);
    }
}

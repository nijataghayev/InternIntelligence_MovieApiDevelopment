package com.example.internintelligence_movieapidevelopment.controller;

import com.example.internintelligence_movieapidevelopment.model.UserDto;
import com.example.internintelligence_movieapidevelopment.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: nijataghayev
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @Operation(summary = "Register a new user", description = "Registers a new user in the system using")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
    }

    @GetMapping("/username/{username}")
    @Operation(summary = "Find  user by username", description = "Retrieves user details using their username. Throws an exception if the user is not found.")
    public UserDto findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PutMapping("/{userId}")
    @Operation(summary = "Update user's details", description = "Updates the details of an existing user by their user ID.")
    public void updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        userService.updateUser(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Delete a user by ID", description = "Deletes a user from the system using their user ID. Throws an exception if the user is not found.")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}

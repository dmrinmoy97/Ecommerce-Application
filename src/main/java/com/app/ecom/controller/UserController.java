package com.app.ecom.controller;

import com.app.ecom.model.User;
import com.app.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
   private final UserService userService;
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable("id") Long id){
        return userService.fetchUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("user added successfully!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id,@RequestBody User user){
       boolean updated= userService.updateUser(id,user);
       if(updated){
           return ResponseEntity.ok("User updated successfully");
       }
       return ResponseEntity.notFound().build();
    }
}

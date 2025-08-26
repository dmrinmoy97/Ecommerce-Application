package com.app.ecom.controller;

import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
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
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUsersById(@PathVariable("id") Long id){
        return userService.fetchUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody UserRequest request){
        userService.addUser(request);
        return ResponseEntity.ok("user added successfully!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id,@RequestBody UserRequest userRequest){
       boolean updated= userService.updateUser(id,userRequest);
       if(updated){
           return ResponseEntity.ok("User updated successfully");
       }
       return ResponseEntity.notFound().build();
    }
}

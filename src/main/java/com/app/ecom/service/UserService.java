package com.app.ecom.service;

import com.app.ecom.model.User;
import com.app.ecom.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> fetchUserById(Long id){
        return userRepository.findById(id);
    }
    public Boolean updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    userRepository.save(existingUser);
                    return true;
                })
                .orElse(false);
    }
//        for(User user1:userList){
//            if(user1.getId().equals(id)){
//                user1.setFirstName(user.getFirstName());
//                user1.setLastName(user.getLastName());
//            }
//            return user1;
//        }
//        return null;

}

package com.app.ecom;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserService {
    long id=1L;
    List<User> userList=new ArrayList<>();
    public List<User> getAllUsers(){
        return userList;
    }
    public List<User> addUser(User user){
        user.setId(id++);
        userList.add(user);
        return userList;
    }
    public Optional<User> fetchUserById(Long id){
        return userList.stream()
                .filter(user->user.getId().equals(id))
                .findFirst();

    }
    public Boolean updateUser(Long id, User user) {
        return userList.stream()
                .filter(user1 -> user1.getId().equals(id))
                .findFirst()
                .map(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
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

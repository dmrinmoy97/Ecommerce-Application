package com.app.ecom.service;

import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.mapper.UserMapper;
import com.app.ecom.model.User;
import com.app.ecom.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<UserResponse> fetchAllUsers(){
        return userRepository.findAll().stream()
                .map(UserMapper::mapToUserResponse)
                .collect(Collectors.toList());
    }
    public void addUser(UserRequest userRequest){
        User user=new User();
        UserMapper.updateUserFromRequest(user, userRequest);
        userRepository.save(user);
    }
    public Optional<UserResponse> fetchUserById(Long id){
        return userRepository.findById(id)
                .map(UserMapper::mapToUserResponse);
    }
    public Boolean updateUser(Long id, UserRequest userRequest) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setFirstName(userRequest.getFirstName());
                    existingUser.setLastName(userRequest.getLastName());
                    userRepository.save(existingUser);
                    return true;
                })
                .orElse(false);
    }
}

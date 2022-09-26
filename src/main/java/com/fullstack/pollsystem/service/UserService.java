package com.fullstack.pollsystem.service;

import com.fullstack.pollsystem.exception.UserNotFoundException;
import com.fullstack.pollsystem.model.User;
import com.fullstack.pollsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user)
    {
        Optional<User> userOptional = userRepo.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }



    public User updateUser(User user)
    {
        return userRepo.save(user);
    }


    public User findUserById(Long id)
    {
        return userRepo.findUserById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
    }

    public void deleteUser(Long id)
    {
        userRepo.deleteUserById(id);
    }


}

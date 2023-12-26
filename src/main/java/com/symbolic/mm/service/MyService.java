package com.symbolic.mm.service;


import com.symbolic.mm.repository.UserRepository;
import com.symbolic.mm.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUser() {
        return repository.findAll();
    }
    public User saveUser(User user){
        return repository.save(user);
    }

    public Optional<User> getUserById(int id){
        Optional<User> user =  repository.findById(id);
        return user;
    }

    public void deleteUserById(int id) {
        repository.deleteById(id);
    }
}

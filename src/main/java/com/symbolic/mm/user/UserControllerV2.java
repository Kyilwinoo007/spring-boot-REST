package com.symbolic.mm.user;

import com.symbolic.mm.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerV2 {

    @Autowired
    MyService userService;
    @GetMapping("/v2/users")
    public List<User> getUser(){
        return  userService.getAllUser();
    }
    @PostMapping("/v2/users")
    public int saveUser(@RequestBody User user){
        User result = userService.saveUser(user);
        return result.id;
    }
    @GetMapping("/v2/users/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        Optional<User> result = userService.getUserById(id);
        return  result;
    }

    @DeleteMapping("/v2/users/{id}")
    public String deleteUserById(@PathVariable int id){
         userService.deleteUserById(id);
         Optional<User> user = getUserById(id);
         if (user.isEmpty()){
             return "Success";
         }
         return "Something Wrong";
    }

}

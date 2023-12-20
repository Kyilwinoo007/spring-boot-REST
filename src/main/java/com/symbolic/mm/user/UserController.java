package com.symbolic.mm.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDaoService userService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return  userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){

        User user =  userService.findUserById(id);
        if (user == null){
            throw new UserNotFoundException("id -" + id);
        }
        return  user;
    }

    @PostMapping("/users")
    public int createUser(@RequestBody User user){
         User result = userService.insertUser(user);
         return result.id;
    }

    @GetMapping("/userByName")
    public List<User> getUserByName(@RequestParam(value = "name",defaultValue = "Miria")String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/userWithHeaders")
    public User getUserByIdAndName(@RequestHeader(value = "name")String name,@RequestHeader("id")int id){
        return userService.getUserByNameAndId(name,id);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUserById(@PathVariable int id){
        return userService.deleteUserById(id);
    }
}

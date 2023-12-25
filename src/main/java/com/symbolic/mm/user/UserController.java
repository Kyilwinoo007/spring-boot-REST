package com.symbolic.mm.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {
    @Autowired
    UserDaoService userService;

    @Autowired
    private MessageSource messageSource;

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
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
         User result = userService.insertUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.id).toUri();

       return ResponseEntity.created(location).build();
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

    @GetMapping(value = "/getMessage" , headers = "Api_Version=1")
    public String getMessage(){
        return messageSource.getMessage("hello.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping(value = "/getMessage",headers = "Api_Version=2")
    public String getMessageV2(){
        return messageSource.getMessage("hello.message", null, LocaleContextHolder.getLocale()) + " version 2";
    }
}

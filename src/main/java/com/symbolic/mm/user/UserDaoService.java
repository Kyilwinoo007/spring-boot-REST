package com.symbolic.mm.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private int userCount = 0;
//    static {
//        users.add(new User(10,"John",new Date()));
//        users.add(new User(11,"Miria",new Date()));
//        users.add(new User(12,"Don",new Date()));
//    }
    public int getUserCount(){
        return  userCount;
    }
    public User insertUser(User user){
       if (user.id < 0){
           user.setId(++userCount);
       }
       users.add(user);
        return user;
    }
    public List<User> getAllUser(){
        return users;
    }
    public User findUserById(int id){
        for (User user: users){
            if (user.id == id){
                return user;
            }
        }
        return null;
    }

    public List<User> getUserByName(String name) {
        List<User> tmp = new ArrayList<>();
        for (User user: users){
            if (user.name.startsWith(name)){
                tmp.add(user);
            }
        }
        return tmp;
    }

    public User getUserByNameAndId(String name, int id) {
        for (User user: users){
            if (user.name.equalsIgnoreCase(name) && user.id == id){
                return user;
            }
        }
        return null;
    }

    public User deleteUserById(int id) {
        for (User user: users){
            if (user.id == id){
                users.remove(user);
                return user;
            }
        }
        return null;
    }
}

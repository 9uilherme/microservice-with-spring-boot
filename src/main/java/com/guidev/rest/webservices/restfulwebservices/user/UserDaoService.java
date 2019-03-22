package com.guidev.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

@Component
public class UserDaoService {

    @Autowired
    private UserRepository userRepository;

    /*
    private static List<User> users = new ArrayList<>();

    private static Integer count = 3;

    static {
        users.add(new User(1, "Gui", new Date()));
        users.add(new User(2, "Iza", new Date()));
        users.add(new User(3, "Meg", new Date()));
    }
    */

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) throw new UserNotFoundException("User not found!");
        return user.get();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User deleteById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) throw new UserNotFoundException("User not found!");
        userRepository.deleteById(id);
        return user.get();
    }
}

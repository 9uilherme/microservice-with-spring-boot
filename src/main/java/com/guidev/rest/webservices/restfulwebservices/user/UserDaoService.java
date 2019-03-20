package com.guidev.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer count = 3;

    static {
        users.add(new User(1, "Gui", new Date()));
        users.add(new User(2, "Iza", new Date()));
        users.add(new User(3, "Meg", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(Integer id){
        for (User user: users) {
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public User save(User user){
        if(StringUtils.isEmpty(user.getId())){
            user.setId(++count);
        }
        users.add(user);
        return user;
    }

    public User deleteById(Integer id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;

    }
}

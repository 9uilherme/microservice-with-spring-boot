package com.guidev.rest.webservices.restfulwebservices.user;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("users/{id}")
    public User retrieveUser(@PathVariable Integer id){
        User user = service.findOne(id);
        if(user == null)
            throw  new UserNotFoundException("id-"+id);
        return user;
    }

    @PostMapping("users")
    public ResponseEntity save(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Integer id){
        User user = service.deleteById(id);
        if(user == null)
            throw  new UserNotFoundException("id-"+id);
    }
}

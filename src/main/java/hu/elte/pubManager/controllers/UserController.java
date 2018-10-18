/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers;

import hu.elte.pubManager.entities.User;
import hu.elte.pubManager.services.UserDaoService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import hu.elte.pubManager.exceptions.UserNotFoundException;
import hu.elte.pubManager.repositories.UserRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author madave91
 */
@RestController
public class UserController {
    @Autowired
    private UserDaoService service;
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return userRepository.findAll();
    }
    
    @GetMapping("/users/{id}")
    public Resource<User> retriveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        Resource<User> resource = new Resource<>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }
    
    //ekkor a request body adja át a User-t
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser =  userRepository.save(user);
       
       //send back the created user
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedUser.getId())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
        
}

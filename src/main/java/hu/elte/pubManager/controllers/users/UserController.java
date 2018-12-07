/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers.users;

import hu.elte.pubManager.entities.Users.Users;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import hu.elte.pubManager.exceptions.UserNotFoundException;
import hu.elte.pubManager.repositories.users.UserRepository;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
//GETTERS
    @ApiModelProperty(notes="Get All User")
    @GetMapping("/users")
    public List<Users> retriveAllUsers(){
        return userRepository.findAll();
    }
    
    @ApiModelProperty(notes="Get User By ID")
    @GetMapping("/users/{id}")
    public Resource<Users> retriveUser(@PathVariable int id){
        Optional<Users> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        Resource<Users> resource = new Resource<>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }
    
    
//POSTERS
    @ApiModelProperty(notes="Create User")
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user){
        Users savedUser =  userRepository.save(user);
       
       //send back the created user
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedUser.getUserId())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @ApiModelProperty(notes="Delete User By ID")
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
        
}

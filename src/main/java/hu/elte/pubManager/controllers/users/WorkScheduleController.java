/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers.users;

import hu.elte.pubManager.entities.Users.WorkSchedule;
import hu.elte.pubManager.exceptions.UserNotFoundException;
import hu.elte.pubManager.repositories.users.WorkScheduleRepository;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
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
public class WorkScheduleController {
    @Autowired
    private WorkScheduleRepository workScheduleRepository;
   
//GETTERS
    @ApiModelProperty(notes="Get All WorkSchedule entry")
    @GetMapping("/workschedule")
    public List<WorkSchedule> retriveAllWorkSchedules(){
        return workScheduleRepository.findAll();
    }
    
    @ApiModelProperty(notes="Get a WorkSchedule By Id")
    @GetMapping("/workschedule/{id}")
    public Resource<WorkSchedule> retriveWorkSchedule(@PathVariable int id){
        Optional<WorkSchedule> schedule = workScheduleRepository.findById(id);
        if(!schedule.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        Resource<WorkSchedule> resource = new Resource<>(schedule.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllWorkSchedules());
        resource.add(linkTo.withRel("all-schedules"));
        return resource;
    }
    
//POSTERS
    @ApiModelProperty(notes="Create a new Work Schedule entry")
    @PostMapping("/workschedule")
    public ResponseEntity<Object> createWorkSchedule(@Valid @RequestBody WorkSchedule workSchedule){
        WorkSchedule savedWorkSchedule =  workScheduleRepository.save(workSchedule);
       
       //send back the created user
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedWorkSchedule.getScheduleId())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @ApiModelProperty(notes="Delete a Work Schedule entry By Id")
    @DeleteMapping("/workschedule/{id}")
    public void deleteProduct(@PathVariable int id){
        workScheduleRepository.deleteById(id);
    }
}

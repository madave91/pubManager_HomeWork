/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers.reservations;

import hu.elte.pubManager.entities.Reservations.Reservations;
import hu.elte.pubManager.entities.Reservations.Tables;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import hu.elte.pubManager.exceptions.UserNotFoundException;
import hu.elte.pubManager.repositories.reservations.ReservationRepository;
import hu.elte.pubManager.repositories.reservations.TableRepository;
import io.swagger.annotations.ApiModelProperty;
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
public class TableController {
    @Autowired
    private TableRepository tableRepository;
    
    //GETTERS
    @ApiModelProperty(notes="Get All Table")
    @GetMapping("/tables")
    public List<Tables> retriveAllTables(){
        return tableRepository.findAll();
    }
    
    @ApiModelProperty(notes="Get Table By ID")
    @GetMapping("/tables/{id}")
    public Resource<Tables> retriveTable(@PathVariable int id){
        Optional<Tables> table = tableRepository.findById(id);
        if(!table.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        Resource<Tables> resource = new Resource<>(table.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllTables());
        resource.add(linkTo.withRel("all-tables"));
        return resource;
    }
    
    
//POSTERS
    @ApiModelProperty(notes="Create Table")
    @PostMapping("/tables")
    public ResponseEntity<Object> createTable(@Valid @RequestBody Tables table){
        Tables savedTable =  tableRepository.save(table);
       
       //send back the created user
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedTable.getTableId())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @ApiModelProperty(notes="Create a new Reservation to the Table")
    @PostMapping("/table/{id}/reservation")
    public ResponseEntity<Object> createReservation(@PathVariable Integer id, @RequestBody Reservations reservation){
        Optional<Tables> tableOptional = tableRepository.findById(id);
        if(!tableOptional.isPresent()){
            throw new UserNotFoundException("id-" + id);
        }
        Tables table = tableOptional.get();      
        reservation.setTable(table);
        table.addReservation(reservation);

        
        tableRepository.save(table);
        
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(table.getTableId())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @ApiModelProperty(notes="Delete Table By ID")
    @DeleteMapping("/tables/{id}")
    public void deleteUser(@PathVariable int id){
        tableRepository.deleteById(id);
    }
}

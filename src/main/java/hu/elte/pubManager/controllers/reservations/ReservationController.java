/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers.reservations;

import hu.elte.pubManager.entities.Reservations.Reservations;
import hu.elte.pubManager.exceptions.UserNotFoundException;
import hu.elte.pubManager.repositories.reservations.ReservationRepository;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author madave91
 */
@CrossOrigin("*")
@RestController
public class ReservationController {
        
    @Autowired
    private ReservationRepository reservationRepository;
   
//GETTERS
    @ApiModelProperty(notes="Get All Product")
    @GetMapping("/reservations")
    public List<Reservations> retriveAllReservations(){
        return reservationRepository.findAll();
    }
    
    @ApiModelProperty(notes="Get Product By Id")
    @GetMapping("/reservations/{id}")
    public Resource<Reservations> retriveReservation(@PathVariable int id){
        Optional<Reservations> reservation = reservationRepository.findById(id);
        if(!reservation.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        Resource<Reservations> resource = new Resource<>(reservation.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllReservations());
        resource.add(linkTo.withRel("all-reservations"));
        return resource;
    }
    
//POSTERS
    @ApiModelProperty(notes="Create a new Reservation")
    @PostMapping("/reservations")
    public ResponseEntity<Object> createReservation(@Valid @RequestBody Reservations reservation){
        Reservations savedReservation =  reservationRepository.save(reservation);
       
       //send back the created user
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedReservation.getReservationId())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @ApiModelProperty(notes="Delete a Reservation By Id")
    @DeleteMapping("/reservations/{id}")
    public void deleteProduct(@PathVariable int id){
        reservationRepository.deleteById(id);
    }
}

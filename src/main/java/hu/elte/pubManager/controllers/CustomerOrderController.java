/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers;

import hu.elte.pubManager.entities.CustomerOrder;
import hu.elte.pubManager.entities.CustomerOrderProduct;
import hu.elte.pubManager.entities.Users;
import hu.elte.pubManager.exceptions.UserNotFoundException;
import hu.elte.pubManager.repositories.CustomerOrderRepository;
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
public class CustomerOrderController {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    
//GETTERS
    @ApiModelProperty(notes="Get the Orders")
    @GetMapping("/orders")
    public List<CustomerOrder> retriveAllOrder(){
        return customerOrderRepository.findAll();
    }
    
    @ApiModelProperty(notes="Get Order By ID")
    @GetMapping("/orders/{id}")
    public Resource<CustomerOrder> retriveOrder(@PathVariable int id){
        Optional<CustomerOrder> order = customerOrderRepository.findById(id);
        if(!order.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        Resource<CustomerOrder> resource = new Resource<>(order.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllOrder());
        resource.add(linkTo.withRel("all-orders"));
        return resource;
    }
    //GET THE ORDERS DETAILS
    @ApiModelProperty(notes="Get Order Details By ID")
    @GetMapping("/orders/{id}/details")
    public List<CustomerOrderProduct> retriveDetails(@PathVariable int id){
        Optional<CustomerOrder> order = customerOrderRepository.findById(id);
        if(!order.isPresent()){
            throw new UserNotFoundException("id-" + id);
        }
        return order.get().getCustomerOrderProducts();
    }
    
//POSTERS
    @ApiModelProperty(notes="Create orders")
    @PostMapping("/orders")
    public ResponseEntity<Object> createUser(@Valid @RequestBody CustomerOrder order){
        CustomerOrder savedOrder =  customerOrderRepository.save(order);
       
       //send back the created user
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedOrder.getOrderID())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @ApiModelProperty(notes="Delete Order By ID")
    @DeleteMapping("/orders/{id}")
    public void deleteUser(@PathVariable int id){
        customerOrderRepository.deleteById(id);
    }   
}

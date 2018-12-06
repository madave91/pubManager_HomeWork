/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers.orders;

import hu.elte.pubManager.entities.Orders.CustomerOrder;
import hu.elte.pubManager.entities.Orders.CustomerOrderProduct;
import hu.elte.pubManager.entities.Orders.Products;
import hu.elte.pubManager.exceptions.UserNotFoundException;
import hu.elte.pubManager.repositories.orders.CustomerOrderProductRepository;
import hu.elte.pubManager.repositories.orders.CustomerOrderRepository;
import hu.elte.pubManager.repositories.orders.ProductRepository;
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
public class CustomerOrderController {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    
    @Autowired
    private CustomerOrderProductRepository customerOrderProductRepository;
    
    @Autowired
    private ProductRepository productRepository;
//GETTERS
    @ApiModelProperty(notes="Get all the Orders")
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
  //POST THE ORDER DETAILS
    @ApiModelProperty(notes="Add a new product to the order")
    @PostMapping("/orders/{id}/details")
    public ResponseEntity<Object> createDetails(@PathVariable Integer id, @RequestBody CustomerOrderProduct customerOrderProduct){
        Optional<CustomerOrder> orderOptional = customerOrderRepository.findById(id);
        if(!orderOptional.isPresent()){
            throw new UserNotFoundException("id-" + id);
        }
        CustomerOrder order = orderOptional.get();      
        customerOrderProduct.setCustomerOrder(order);
        
        //get the product
        Optional<Products> productOptional = productRepository.findById(customerOrderProduct.getId());
        if(!productOptional.isPresent()){
            throw new UserNotFoundException("id-" + customerOrderProduct.getId());
        }
        
        Products product = productOptional.get();
        customerOrderProduct.setProducts(product);
        order.calculatePrice(customerOrderProduct.getQuantity(), product.getPrice());
        
        customerOrderProductRepository.save(customerOrderProduct);
        
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(customerOrderProduct.getId())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @ApiModelProperty(notes="Delete Order By ID")
    @DeleteMapping("/orders/{id}")
    public void deleteUser(@PathVariable int id){
        customerOrderRepository.deleteById(id);
    }   
}

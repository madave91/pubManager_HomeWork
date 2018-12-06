/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers.orders;

/**
 *
 * @author madave91
 */
import hu.elte.pubManager.entities.Orders.Products;
import hu.elte.pubManager.exceptions.UserNotFoundException;
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
import hu.elte.pubManager.repositories.orders.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin("*")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
   
//GETTERS
    @ApiModelProperty(notes="Get All Product")
    @GetMapping("/products")
    public List<Products> retriveAllProduct(){
        return productRepository.findAll();
    }
    
    @ApiModelProperty(notes="Get Product By Id")
    @GetMapping("/products/{id}")
    public Resource<Products> retriveProduct(@PathVariable int id){
        Optional<Products> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        Resource<Products> resource = new Resource<>(product.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllProduct());
        resource.add(linkTo.withRel("all-products"));
        return resource;
    }
    
//POSTERS
    @ApiModelProperty(notes="Create a new Product")
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@Valid @RequestBody Products product){
        Products savedProduct =  productRepository.save(product);
       
       //send back the created user
        URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedProduct.getId())
               .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @ApiModelProperty(notes="Delete a Product By Id")
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        productRepository.deleteById(id);
    }
}

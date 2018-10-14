/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.services;

/**
 *
 * @author madave91
 */
import hu.elte.pubManager.entities.Products;
import hu.elte.pubManager.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
       
    public List<Products> productTypeStartingWith(String details) {
        return productRepository.findByType(details);
    }
}

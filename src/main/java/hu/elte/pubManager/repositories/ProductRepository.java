/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.repositories;

import hu.elte.pubManager.entities.Products;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author madave91
 */
@ResponseBody
public interface ProductRepository extends CrudRepository<Products, Long>{
    //Products findByName(String name);
    
    @Query(value = "SELECT product_name, product_price, product_actual_quantity FROM products WHERE product_details=?1%", nativeQuery = true)
    List<Products> findByType(String details);
}

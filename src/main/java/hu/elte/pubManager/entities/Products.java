/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities;
import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/**
 *
 * @author madave91
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", updatable = false, nullable = false)
    private Long id;
    
    @Column(name="product_name", nullable=false, length=255)
    private String name;
    
    @Column(name="product_price", nullable=false, length=10)
    private int price;
    
    @Column(name="product_default_quantity", nullable=false, length=5)
    private float defaultQuantity;
    
    @Column(name="product_actual_quantity", nullable=false, length=5)
    private float actualQuantity;
    
    @Column(name="product_type", nullable=false, length=20)
    private String type;
    
    @Column(name="product_details", nullable=false, length=255)
    private String details;
    
    
}
    /*public Product(){
        super();
    }

    public Product(int id, String name, int price, float defaultQuantity, float actualQuantity, String type, String details) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.defaultQuantity = defaultQuantity;
        this.actualQuantity = actualQuantity;
        this.type = type;
        this.details = details;
    }

//GETTERS
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public float getDefaultQuantity() {
        return defaultQuantity;
    }

    public float getActualQuantity() {
        return actualQuantity;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

//SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDefaultQuantity(float defaultQuantity) {
        this.defaultQuantity = defaultQuantity;
    }

    public void setActualQuantity(float actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    @Override
    public String toString(){
        return String.format("Product: [id: %s, name: %s, price: %s, d_quantity: %s, a_quantity: %s, type: %s, details: %s]",
                                        id, name, price, defaultQuantity, actualQuantity, type, details);
    }
}
*/    

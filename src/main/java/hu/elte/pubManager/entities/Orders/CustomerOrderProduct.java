/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities.Orders;

import hu.elte.pubManager.entities.Orders.CustomerOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.pubManager.exceptions.UserNotFoundException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author madave91
 */
@Entity
@Table(name = "customer_order_product")
public class CustomerOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", updatable = false, nullable = true)
    private Integer id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private CustomerOrder customerOrder;
    
    
    @OneToOne(mappedBy = "customerOrderProduct", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JsonIgnore
    private Products products;
    
    @Column(name="product_name", nullable=false, length=255)
    private String productName;
    
    @Column(name="quantity", nullable=false, length=3)
    private int quantity;
    @Column(name="comment", nullable=true, length=255)
    private String comment;

    public CustomerOrderProduct() {
    }

    //Constructor for webPost
    public CustomerOrderProduct(String productName, int quantity, String comment) {
        try{
            this.products = Products.getProductByName(productName);
        }catch(NullPointerException e)
        {
            throw new UserNotFoundException("There is no product with this name!");
        }
        this.quantity = quantity;
        this.comment = comment;
    }
    //constructor for sql command
    public CustomerOrderProduct(CustomerOrder customerOrder, Products product, int quantity, String comment) {
        this.customerOrder = customerOrder;
        this.products = product;
        this.quantity = quantity;
        this.comment = comment;
    }
    
    
    
    //GETTERS
    
    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }
    

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public Products getProducts() {
        return products;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getComment() {
        return comment;
    }

    //SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void setProducts(Products product) {
        this.products = product;
        setProductName(product.getName());
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    

    

    
    
    
}

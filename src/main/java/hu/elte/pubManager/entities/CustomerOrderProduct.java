/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private CustomerOrder customerOrder;
    
    
    @OneToOne(mappedBy = "customerOrderProduct", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JsonIgnore
    private Products products;
    
    private String productName;
    
    // @Column(name="quantity", nullable=false, length=3)
    private int quantity;
    //@Column(name="comment", nullable=false, length=3)
    private String comment;

    public CustomerOrderProduct() {
    }

    //Constructor for webPost
    public CustomerOrderProduct(Products product, int quantity, String comment) {
        this.products = product;
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

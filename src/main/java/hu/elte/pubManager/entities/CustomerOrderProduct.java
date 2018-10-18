/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author madave91
 */
@Entity
public class CustomerOrderProduct {
    @Id
    @Column(name = "order_id", updatable = false, nullable = false)
    @GeneratedValue
    private Long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private CustomerOrder customerOrder;
    private int quantity;
    private String comment;

    
    
    
    public Long getId() {
        return id;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    

    public int getQuantity() {
        return quantity;
    }

    public String getComment() {
        return comment;
    }

    

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
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

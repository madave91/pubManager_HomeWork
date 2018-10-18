/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author madave91
 */
@Entity
@Table(name = "customer_order")
public class CustomerOrder {
    @Id
    @Column(name = "order_id", updatable = false, nullable = false)
    @GeneratedValue
    private Integer orderID;
    
    @OneToMany(mappedBy="customerOrder")
    private List<CustomerOrderProduct> customerOrderProducts;
    
    @Column(name="price", nullable=false, length=10)
    @ApiModelProperty(notes="Price is in Hungarian Forint")
    private int price;
    
    @Column(name="paid", nullable=false, length=3)
    @ApiModelProperty(notes="Price is in Hungarian Forint")
    private boolean paid;
    
    @Column(name="order_date", nullable=false, length=11)
    @ApiModelProperty(notes="")
    private Date orderDate;

    protected CustomerOrder() {
    }

    public CustomerOrder(int price, boolean paid, Date orderDate) {
        this.price = price;
        this.paid = paid;
        this.orderDate = orderDate;
    }
    
    //GETTERS

    public Integer getOrderID() {
        return orderID;
    }

    public List<CustomerOrderProduct> getCustomerOrderProducts() {
        return customerOrderProducts;
    }

    public int getPrice() {
        return price;
    }

    public Date getOrderDate() {
        return orderDate;
    }
    public boolean getPaid(){
        return paid;
    }

    //SETTERS
    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public void setCustomerOrderProducts(List<CustomerOrderProduct> customerOrderProducts) {
        this.customerOrderProducts = customerOrderProducts;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
    
    
}

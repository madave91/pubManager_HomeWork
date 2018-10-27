/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities.Reservations;

import hu.elte.pubManager.entities.Orders.CustomerOrderProduct;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author madave91
 */
@Entity
@Table(name = "tables")
public class Tables {
    //Table Number
    @Id
    @Column(name = "table_id", updatable = false, nullable = false)
    @GeneratedValue
    private Integer tableId;
    //SeatNum
    @Column(name = "seat_number", updatable = false, nullable = false)
    @GeneratedValue
    private Integer seatNumber;
    
    //Reservations
    @OneToMany(mappedBy="table")
    private List<Reservations> reservations;

    public Tables() {
    }

    public Tables(Integer tableId, Integer seatNumber, List<Reservations> reservations) {
        this.tableId = tableId;
        this.seatNumber = seatNumber;
        this.reservations = reservations;
    }

    public List<Reservations> getReservations() {
        return reservations;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
    
    public void addReservation(Reservations reservation){
        this.reservations.add(reservation);
    }
    public void deleteReservation(int id){
        Iterator reservationIterator = this.reservations.iterator();
        while(reservationIterator.hasNext()){
            Reservations reservation = (Reservations) reservationIterator.next();
            if(reservation.getReservationId() == id){
                reservationIterator.remove();
            }
        }
    }
    
    
}

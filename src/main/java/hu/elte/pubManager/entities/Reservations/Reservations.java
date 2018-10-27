/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities.Reservations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.pubManager.entities.Orders.CustomerOrder;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;

/**
 *
 * @author madave91
 */
@Entity
@Table(name = "reservations")
public class Reservations {
    //Id
    @Id
    @Column(name = "reservation_id", updatable = false, nullable = false)
    @GeneratedValue
    private Integer reservationId;
    //Table
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Tables table;
    //Date
    @Future
    @Column(name="reservation_date", nullable=false, length=11)
    @ApiModelProperty(notes="")
    private Date reservationDate;
    //Reservation Name
    @Column(name="reservation_name", nullable=false, length=256)
    private String name;
   
    //FromTime
    @Column(name="from_time", nullable=false, length=5)
    @ApiModelProperty(notes="")
    private Time fromTime;
    //UntilTime
    @Column(name="until_time", nullable=false, length=5)
    @ApiModelProperty(notes="")
    private Time UntilTime;

    public Reservations() {
    }

    public Reservations(Integer reservationId, Tables table, String name, Date reservationDate, Time fromTime, Time UntilTime) {
        this.reservationId = reservationId;
        this.table = table;
        this.reservationDate = reservationDate;
        this.name = name;
        this.fromTime = fromTime;
        this.UntilTime = UntilTime;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public Time getFromTime() {
        return fromTime;
    }

    public Tables getTable() {
        return table;
    }

    public Time getUntilTime() {
        return UntilTime;
    }

    public String getName() {
        return name;
    }
    

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public void setFromTime(Time fromTime) {
        this.fromTime = fromTime;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    public void setUntilTime(Time UntilTime) {
        this.UntilTime = UntilTime;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

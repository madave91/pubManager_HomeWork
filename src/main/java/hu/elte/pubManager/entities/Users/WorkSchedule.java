/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author madave91
 */
@Entity
@Table(name = "work_schedule")
public class WorkSchedule {
    
    @Id
    @Column(name = "schedule_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scheduleId;
    
    //User
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Users user;
    //Date
    @Column(name="work_date", nullable=false, length=11)
    @ApiModelProperty(notes="")
    private Date workDate;
    //FromTime
    @Column(name="from_time", nullable=false, length=5)
    @ApiModelProperty(notes="")
    private Time fromTime;
    //UntilTime
    @Column(name="until_time", nullable=false, length=5)
    @ApiModelProperty(notes="")
    private Time UntilTime;

    public WorkSchedule() {
    }

    public WorkSchedule(Integer scheduleId, Users user, Date workDate, Time fromTime, Time UntilTime) {
        this.scheduleId = scheduleId;
        this.user = user;
        this.workDate = workDate;
        this.fromTime = fromTime;
        this.UntilTime = UntilTime;
    }

    public Time getFromTime() {
        return fromTime;
    }

    public Time getUntilTime() {
        return UntilTime;
    }

    public Users getUser() {
        return user;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setFromTime(Time fromTime) {
        this.fromTime = fromTime;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setUntilTime(Time UntilTime) {
        this.UntilTime = UntilTime;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities.Users;

import hu.elte.pubManager.entities.Reservations.Tables;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author madave91
 */
@Entity
@ApiModel(description="User details")
public class Users {
    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    @GeneratedValue
    private Integer userId;
   
    @Column(name="user_fname", nullable=false, length=255)
    @Size(min=2, message="Name Should have at least 2 character long!")
    @ApiModelProperty(notes="Name Should have at least 2 character long!")
    private String fName;
    
    @Column(name="user_lname", nullable=false, length=255)
    @Size(min=2, message="Name Should have at least 2 character long!")
    @ApiModelProperty(notes="Name Should have at least 2 character long!")
    private String lName;
    
    @Column(name="user_login_name", nullable=false, length=255)
    @Size(min=2, message="Name Should have at least 2 character long!")
    @ApiModelProperty(notes="Name Should have at least 2 character long!")
    private String loginName;
    
    //@Past
    @Column(name="birth_date", nullable=false, length=11)
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date birthDate;

    //Phone
    @Column(name="phone_number", nullable=false, length=16)
    @Size(min=5, message="Name Should have at least 5 character long!")
    @ApiModelProperty(notes="Name Should have at least 5 character long!")
    private String phoneNumber;
    //Email
    @Column(name="email", nullable=false, length=255)
    @Size(min=2, message="Name Should have at least 2 character long!")
    @ApiModelProperty(notes="Name Should have at least 2 character long!")
    private String email;
    
    //WorkSchedules
    @OneToMany(mappedBy="user")
    private List<WorkSchedule> workSchedules;
    //Password?
    //Role
    
    protected Users(){
        
    }

    public Users(Integer userId, String fName, String lName, String loginName, Date birthDate, String phoneNumber, String email) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.loginName = loginName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    
   
    
    
    
//GETTERS
    public Integer getUserId() {
        return userId;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<WorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

   

    public Date getBirthDate() {
        return birthDate;
    }
    
//SETTERS

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWorkSchedules(List<WorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
}

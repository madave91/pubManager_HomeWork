/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private Integer id;
   
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

    protected Users(){
        
    }

    public Users(String fName, String lName, String loginName, Date birthDate) {
        this.fName = fName;
        this.lName = lName;
        this.loginName = loginName;
        this.birthDate = birthDate;
    }
   
    
    
    
//GETTERS
    public Integer getId() {
        return id;
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

   

    public Date getBirthDate() {
        return birthDate;
    }
    
//SETTERS

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
}

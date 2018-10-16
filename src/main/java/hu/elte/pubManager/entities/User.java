/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author madave91
 */
@ApiModel(description="User details")
public class User {
    private Integer id;
   
    @Size(min=2, message="Name Should have at least 2 character long!")
    @ApiModelProperty(notes="Name Should have at least 2 character long!")
    private String name;
    
    @Past
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date birthDate;

    protected User(){
        
    }
    public User(int id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    
    
    
//GETTERS
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    
//SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
}

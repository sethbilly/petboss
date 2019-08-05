/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.jpa.DateRecord;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ICSGH-BILLY
 */
@Table(name = "pet_boarding")
@Entity
public class PetBoarding extends DateRecord
{
    public static final String _pet = "pet";
    @JoinColumn(name = "pet")
    @ManyToOne
    private Pet pet;
    
    @Column(name = "description")
    private String description;
    
    public static final String _arrivalDate = "fromDate";
    @Column(name = "from_date")
    @Temporal(value = TemporalType.DATE)
    private Date fromDate;
    
    public static final String _dischargeDate = "toDate";
    @Column(name = "to_date")
    @Temporal(value = TemporalType.DATE)
    private Date toDate;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    public Pet getPet()
    {
        return pet;
    }

    public void setPet(Pet pet)
    {
        this.pet = pet;
    }
    
}

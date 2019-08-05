/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.jpa.ContactModel;
import com.thekeigroup.petboss.constants.StaffCategory;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ICSGH-BILLY
 */
@Table(name = "staff")
@Entity
public class Staff extends ContactModel {

    public static final String _surname = "surname";
    @Column(name = "surname")
    private String surname;
    
    public static final String _otherNames = "otherNames";
    @Column(name = "other_names")
    private String otherNames;
    
    public static final String _dateOfRegistration = "dateOfRegistration";
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    public static final String _active = "active";
    @Column(name = "active")
    private boolean active;
    
    public static final String _statffCategory = "staffCategory";
    @Column(name = "staff_category")
    @Enumerated(EnumType.STRING)
    private StaffCategory staffCategory;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherNames() {
        return otherNames;
    }
    
    public String getStaffFullName(){
        return surname + " " + otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public StaffCategory getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(StaffCategory staffCategory) {
        this.staffCategory = staffCategory;
    }
    
}

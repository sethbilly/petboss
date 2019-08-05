/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.jpa.CommonModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Billy
 */
@Table(name = "user_account")
@Entity
public class UserAccount extends CommonModel {

    public static final String _username = "username";
    @Column(name = "username")
    private String username;
    
    public static final String _password = "password";
    @Column(name = "password")
    private String password;
    
    public static final String _staff = "staff";
    @OneToOne
    @JoinColumn(name = "staff")
    private Staff staff;
    
    public static final String _active = "active";
    @Column(name = "active")
    private boolean active;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    
    
}

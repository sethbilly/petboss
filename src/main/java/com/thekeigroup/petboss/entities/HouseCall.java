/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.constants.StatusCode;
import com.latlab.common.jpa.DateRecord;
import com.thekeigroup.petboss.constants.BookingType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ICSGH-BILLY
 */
@Table(name = "bookings")
@Entity
public class HouseCall extends DateRecord
{
    public static final String _client = "client";
    @JoinColumn(name = "client")
    @ManyToOne
    private Client client;
    
    @Column(name = "description")
    private String description;
    
    public static final String _bookingSlot = "bookingSlot";
    @Column(name = "booking_slot")
    @Temporal(value = TemporalType.DATE)
    private Date bookingSlot;
    
    public static final String _bookingType = "bookingType";
    @Column(name = "booking_type")
    @Enumerated(EnumType.STRING)
    private BookingType bookingType = BookingType.HOUSE_CALL;
    
    public static final String _assignedStaff = "assignedStaff";
    @ManyToOne
    @JoinColumn(name = "assigned_staff")
    private Staff assignedStaff;
    
    public static final String _status = "status";
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusCode status = StatusCode.PENDING;
    
    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getBookingSlot()
    {
        return bookingSlot;
    }

    public void setBookingSlot(Date bookingSlot)
    {
        this.bookingSlot = bookingSlot;
    }

    public BookingType getBookingType()
    {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType)
    {
        this.bookingType = bookingType;
    }

    public Staff getAssignedStaff() {
        return assignedStaff;
    }

    public void setAssignedStaff(Staff assignedStaff) {
        this.assignedStaff = assignedStaff;
    }

    public StatusCode getStatus() {
        return status;
    }

    public void setStatus(StatusCode status) {
        this.status = status;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.latlab.common.jpa.CrudController;
import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.HouseCall;
import com.thekeigroup.petboss.entities.Client;
import com.thekeigroup.petboss.services.CommonService;
import com.thekeigroup.petboss.services.CrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author seth
 */
@Named(value = "bookingController")
@SessionScoped
public class BookingController implements Serializable
{

    @Inject
    private CrudService crudService;
    @Inject
    private CommonService commonService;
    @Inject 
    private ClientSearchController clientSearchController;

    private HouseCall booking = new HouseCall();
    private Client selectedClient;
    private List<HouseCall> bookingsList = new ArrayList<>();
    private Date today = new Date();

    public void selectClient()
    {
        selectedClient = clientSearchController.getSelectedClient();
        
    }

    public void saveBooking()
    {
        try
        {
            if(null == selectedClient)
            {
                Msg.genericError("Please select a client to book house call for.");
                return ;
            }
            if(null == booking.getBookingSlot())
            {
                Msg.genericError("Please select a time slot for house call");
                return;
            }
            booking.setClient(selectedClient);
            if (crudService.save(booking) != null)
            {
                Msg.successSave();
                clear();
            }
        } catch (Exception e)
        {
            Msg.failedSave();
            e.printStackTrace();
        }
    }
    

    public void clear()
    {
      booking = new HouseCall();
      selectedClient = null;
    }
    public void selectBooking(HouseCall selectedBooking)
    {
        this.booking = selectedBooking;
    }

    public void deleteBooking(HouseCall selectedBooking)
    {
        try
        {
            if (crudService.delete(booking, false))
            {
                Msg.successDelete();
            }
        } catch (Exception e)
        {
            Msg.failedDelete();
            e.printStackTrace();
        }
    }

    public HouseCall getBooking()
    {
        return booking;
    }

    public void setBooking(HouseCall booking)
    {
        this.booking = booking;
    }

    public List<HouseCall> getBookingsList()
    {
        bookingsList = commonService.clientHouseCallList(selectedClient);
        return bookingsList;
    }

    public void setBookingsList(List<HouseCall> bookingsList)
    {
        this.bookingsList = bookingsList;
    }

    public Date getToday()
    {
        return today;
    }

    public void setToday(Date today)
    {
        this.today = today;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }
    
}

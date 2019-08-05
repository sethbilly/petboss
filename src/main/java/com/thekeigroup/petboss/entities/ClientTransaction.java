/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.jpa.DateRecord;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ICSGH-BILLY
 */
@Table(name = "client_transaction")
@Entity
public class ClientTransaction extends DateRecord
{

    public static final String _client = "client";
    @JoinColumn(name = "client")
    @ManyToOne
    private Client client;
    
    @Column(name = "credit")
    private double credit;

    @Column(name = "debit")
    private double debit;
    
    @Column(name = "description")
    private String description;

    public double getCredit()
    {
        return credit;
    }

    public void setCredit(double credit)
    {
        this.credit = credit;
    }

    public double getDebit()
    {
        return debit;
    }

    public void setDebit(double debit)
    {
        this.debit = debit;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }
    
}

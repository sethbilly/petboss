/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.models;

import java.io.Serializable;

/**
 *
 * @author INF-BILLY
 */
public class PrescriptionDetails implements Serializable
{
    private String prescription;
    private String dosage;
    private double price;
    private double itemAmount;

    public String getPrescription()
    {
        return prescription;
    }

    public void setPrescription(String prescription)
    {
        this.prescription = prescription;
    }

    public String getDosage()
    {
        return dosage;
    }

    public void setDosage(String dosage)
    {
        this.dosage = dosage;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getItemAmount()
    {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount)
    {
        this.itemAmount = itemAmount;
    }
    
    
}

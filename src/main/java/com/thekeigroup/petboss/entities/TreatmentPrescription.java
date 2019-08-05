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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ICSGH-BILLY
 */
@Table(name = "treatment_prescription")
@Entity
public class TreatmentPrescription extends CommonModel {

    public static final String _treatment = "treatment";
    @JoinColumn(name = "treatment")
    @ManyToOne
    private Treatment treatment;
    
    public static final String _prescriptionId = "prescription";
    @Column(name = "prescription")
    private String prescription;
    
    public static final String _product = "product";
    @JoinColumn(name = "product")
    @ManyToOne
    private Product product;
    
    @Column(name = "dosage_quantity")
    private String dosageQuantity;
    
    @Column(name = "price")
    private double price;

    public Treatment getTreatment()
    {
        return treatment;
    }

    public void setTreatment(Treatment treatment)
    {
        this.treatment = treatment;
    }

    public String getPrescription()
    {
        return prescription;
    }

    public void setPrescription(String prescription)
    {
        this.prescription = prescription;
    }

    public String getDosageQuantity()
    {
        return dosageQuantity;
    }

    public void setDosageQuantity(String dosageQuantity)
    {
        this.dosageQuantity = dosageQuantity;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }
    
}

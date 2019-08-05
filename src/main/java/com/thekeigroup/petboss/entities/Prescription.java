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
 * @author seth
 */
@Table(name = "prescriptions")
@Entity
public class Prescription extends CommonModel{
   
    public static final String _diagnosis = "diagnosis";
    public static final String _diagnosis_diagnosisName = _diagnosis + "." + Diagnosis._diagnosisName;
    @JoinColumn(name = "diagnosis")
    @ManyToOne
    private Diagnosis diagnosis;
    
    
    public static final String _product = "product";
    public static final String _product_productName = _product + "." + Product._productName;
    @JoinColumn(name = "product")
    @ManyToOne
    private Product product;
    
    @Column(name = "dosage_quantity")
    private String dosageQuantity;
    
    @Column(name = "price")
    private double price;

    public Diagnosis getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
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

    
}

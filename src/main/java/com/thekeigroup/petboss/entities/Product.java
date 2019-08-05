/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.jpa.CommonModel;
import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ICSGH-BILLY
 */
@Entity
@Table(name = "products")
@Cacheable(false)
public class Product extends CommonModel implements Serializable
{
    
    public static final String _productName = "productName";
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "front_image")
    private String frontImage;

    @Column(name = "side_image")
    private String sideImage;
    
    @Column(name = "dosage_qty")
    private String dosageQty;
    
    @Column(name = "direction_of_use")
    private String directionOfUse;
    
    @Column(name = "side_effect")
    private String sideEffect;
    
    @JoinColumn(name = "product_form")
    @ManyToOne
    private ProductForm productForm;
   
    @Column(name = "unit_price")
    private double unitPrice;

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductDescription()
    {
        return productDescription;
    }

    public void setProductDescription(String productDescription)
    {
        this.productDescription = productDescription;
    }

    public String getCoverImage()
    {
        return coverImage;
    }

    public void setCoverImage(String coverImage)
    {
        this.coverImage = coverImage;
    }

    public String getFrontImage()
    {
        return frontImage;
    }

    public void setFrontImage(String frontImage)
    {
        this.frontImage = frontImage;
    }

    public String getSideImage()
    {
        return sideImage;
    }

    public void setSideImage(String sideImage)
    {
        this.sideImage = sideImage;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public String getDosageQty()
    {
        return dosageQty;
    }

    public void setDosageQty(String dosageQty)
    {
        this.dosageQty = dosageQty;
    }

    public String getDirectionOfUse()
    {
        return directionOfUse;
    }

    public void setDirectionOfUse(String directionOfUse)
    {
        this.directionOfUse = directionOfUse;
    }

    public String getSideEffect()
    {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect)
    {
        this.sideEffect = sideEffect;
    }

    public ProductForm getProductForm()
    {
        return productForm;
    }

    public void setProductForm(ProductForm productForm)
    {
        this.productForm = productForm;
    }
    
    
    @Override
    public String toString()
    {
        return productName;
    }

}

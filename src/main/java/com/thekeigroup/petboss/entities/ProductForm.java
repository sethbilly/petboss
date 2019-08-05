/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.jpa.CommonModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ICSGH-BILLY
 */
@Table(name = "product_form")
@Entity
public class ProductForm extends CommonModel
{
    @Column(name = "form_name")
    private String formName;
    
    @Column(name = "description")
    private String description;
    
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getFormName()
    {
        return formName;
    }

    public void setFormName(String formName)
    {
        this.formName = formName;
    }

    @Override
    public String toString()
    {
        return formName;
    }
    
}

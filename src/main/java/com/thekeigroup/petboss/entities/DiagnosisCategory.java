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
@Table(name = "diagnosis_category")
@Entity
public class DiagnosisCategory extends CommonModel
{

    public static final String _diagnosisCategoryName = "diagnosisCategoryName";
    @Column(name = "diagnosis_name")
    public String diagnosisName;

    @Column(name = "description")
    public String description;

    public String getDiagnosisName()
    {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName)
    {
        this.diagnosisName = diagnosisName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return  diagnosisName;
    }
    
}

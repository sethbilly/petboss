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
@Table(name = "diagnosis")
@Entity
public class Diagnosis extends CommonModel {
    
    public static final String _diagnosisName = "diagnosisName";
    @Column(name = "diagnosis_name")
    private String diagnosisName;
    
    @Column(name = "description")
    private String description;
    
    public static final String _diagnosisCategory = "diagnosisCategory";
    @JoinColumn(name = "diagnosis_category")
    @ManyToOne
    private DiagnosisCategory diagnosisCategory;

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return diagnosisName;
    }

    public DiagnosisCategory getDiagnosisCategory()
    {
        return diagnosisCategory;
    }

    public void setDiagnosisCategory(DiagnosisCategory diagnosisCategory)
    {
        this.diagnosisCategory = diagnosisCategory;
    }
    
}

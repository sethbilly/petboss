/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.jpa.DateRecord;
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
@Table(name = "treatments")
@Entity
public class Treatment extends DateRecord {

    @Column(name = "description")
    private String description;

    public static final String _pet = "pet";
    @JoinColumn(name = "pet")
    @ManyToOne
    private Pet pet;

    @JoinColumn(name = "treatment_type")
    @ManyToOne
    private DiagnosisCategory treatmentType;

    public static final String _diagnosis = "diagnosis";
    public static final String _diagnosisName = _diagnosis + "." + Diagnosis._diagnosisName;
    public static final String _diagnosis_diagnosisCategory = _diagnosis + "." + Diagnosis._diagnosisCategory;
    @JoinColumn(name = "diagnosis")
    @ManyToOne
    private Diagnosis diagnosis;
    
    @Column(name = "comment")
    private String comment;
    
    @Column(name = "next_treatment_date")
    @Temporal(TemporalType.DATE)
    private Date nextTreatmentDate;
    
    @Column(name = "temperature")
    private double temperature;
    
    @Column(name = "weight")
    private double weight;
    
    @Column(name = "total_cost")
    private double totalCost;
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public DiagnosisCategory getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(DiagnosisCategory treatmentType) {
        this.treatmentType = treatmentType;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getNextTreatmentDate()
    {
        return nextTreatmentDate;
    }

    public void setNextTreatmentDate(Date nextTreatmentDate)
    {
        this.nextTreatmentDate = nextTreatmentDate;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.thekeigroup.petboss.entities.Prescription;
import com.thekeigroup.petboss.services.CommonService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author seth
 */
@Named(value = "prescriptionSearchController")
@SessionScoped
public class PrescriptionSearchController implements Serializable{
    
    @Inject private CommonService commonService;
    private List<Prescription> prescriptionsList = new ArrayList<>();
    private Prescription selectedPrescription;
    private String searchText;
    
    public void searchPrescription(){
        Prescription prescriptionQp = new Prescription();
        
        
    }

    public List<Prescription> getPrescriptionsList() {
        return prescriptionsList;
    }

    public void setPrescriptionsList(List<Prescription> prescriptionsList) {
        this.prescriptionsList = prescriptionsList;
    }

    public Prescription getSelectedPrescription() {
        return selectedPrescription;
    }

    public void setSelectedPrescription(Prescription selectedPrescription) {
        this.selectedPrescription = selectedPrescription;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    
    
}

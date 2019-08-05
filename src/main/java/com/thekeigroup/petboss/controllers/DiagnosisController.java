/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.google.common.base.Strings;
import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.Diagnosis;
import com.thekeigroup.petboss.services.CommonService;
import com.thekeigroup.petboss.services.CrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ICSGH-BILLY
 */
@Named(value = "diagnosisController")
@SessionScoped
public class DiagnosisController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject 
    private CommonService commonService;
    
    private Diagnosis diagnosis = new Diagnosis();
    private List<Diagnosis> diagnosisList = new ArrayList<>();
 
    
    public void saveDiagnosis(){
        
        try {
            
            if(Strings.isNullOrEmpty(diagnosis.getDiagnosisName()))
            {
                Msg.genericError("Diagnosis Name is required");
                return;
            }
            if(crudService.save(diagnosis) != null){
                Msg.successSave();
                clear();
            }
        } catch (Exception e) {
            Msg.failedSave();
            e.printStackTrace();
        }
    }
    
    public void selectDiagnosis(Diagnosis selectedDiagnosis){
        this.diagnosis = selectedDiagnosis;
    }
    
    public void deleteDiagnosis(Diagnosis selectedDiagnosis){
        try {
            if(crudService.delete(selectedDiagnosis, false)){
                Msg.successDelete();
            }
        } catch (Exception e) {
            Msg.failedDelete();
            e.printStackTrace();
        }
    }
    
    public void clear(){
        diagnosis = new Diagnosis();
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<Diagnosis> getDiagnosisList() {
        diagnosisList = new ArrayList<>(commonService.getDiagnosisList());
        return diagnosisList;
    }

    public void setDiagnosisList(List<Diagnosis> diagnosisList) {
        this.diagnosisList = diagnosisList;
    }
    
    
}

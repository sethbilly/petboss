/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.google.common.base.Strings;
import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.DiagnosisCategory;
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
@Named(value = "diagnosisCategoryController")
@SessionScoped
public class DiagnosisCategoryController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject 
    private CommonService commonService;
    
    private DiagnosisCategory diagnosis = new DiagnosisCategory();
    private List<DiagnosisCategory> diagnosisList = new ArrayList<>();
 
    
    public void saveDiagnosis(){
        try {
            if(Strings.isNullOrEmpty(diagnosis.getDiagnosisName()))
            {
                Msg.genericError("Diagnosis Category Name is required");
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
    
    public void selectDiagnosisCategory(DiagnosisCategory selectedDiagnosis){
        this.diagnosis = selectedDiagnosis;
    }
    
    public void deleteDiagnosis(DiagnosisCategory selectedDiagnosis){
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
        diagnosis = new DiagnosisCategory();
    }

    public DiagnosisCategory getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisCategory diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public List<DiagnosisCategory> getDiagnosisList()
    {
        return diagnosisList = commonService.getDiagnosisCategoryList();
    }

    public void setDiagnosisList(List<DiagnosisCategory> diagnosisList)
    {
        this.diagnosisList = diagnosisList;
    }

   
    
}

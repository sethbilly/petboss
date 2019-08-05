/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.thekeigroup.petboss.entities.Diagnosis;
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
@Named(value = "diagnosisSearchController")
@SessionScoped
public class DiagnosisSearchController implements Serializable{
    
    @Inject
    private CommonService commonService;
    
    private List<Diagnosis> diagnosisList = new ArrayList<>();
    private Diagnosis selectedDiagnosis;
    private String searchText;
    
    public  void searchDiagnosis() {
        try
        {
            Diagnosis diagnosisQP = new Diagnosis();
            diagnosisQP.setDiagnosisName(searchText);
            
            diagnosisList = commonService.getDiagnosisListByAttribute(diagnosisQP);
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Diagnosis> getDiagnosisList()
    {
        return diagnosisList;
    }

    public void setDiagnosisList(List<Diagnosis> diagnosisList)
    {
        this.diagnosisList = diagnosisList;
    }

    public Diagnosis getSelectedDiagnosis()
    {
        return selectedDiagnosis;
    }

    public void setSelectedDiagnosis(Diagnosis selectedDiagnosis)
    {
        this.selectedDiagnosis = selectedDiagnosis;
    }

    public String getSearchText()
    {
        return searchText;
    }

    public void setSearchText(String searchText)
    {
        this.searchText = searchText;
    }
    
    
}

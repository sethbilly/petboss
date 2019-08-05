/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.DiagnosisCategory;
import com.thekeigroup.petboss.entities.Diagnosis;
import com.thekeigroup.petboss.entities.Pet;
import com.thekeigroup.petboss.entities.Prescription;
import com.thekeigroup.petboss.entities.Treatment;
import com.thekeigroup.petboss.entities.TreatmentPrescription;
import com.thekeigroup.petboss.services.CommonService;
import com.thekeigroup.petboss.services.CrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ICSGH-BILLY
 */
@Named(value = "vaccinationController")
@SessionScoped
public class VaccinationController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject 
    private CommonService commonService;
    @Inject
    private PetSeachController petSeachController;
    
    private Treatment treatment = new Treatment();
    private List<Treatment> treatmentsList = new ArrayList<>();
    private Pet selectedPet;
    private Diagnosis  selectedDiagnosis;
    private List<Prescription> prescriptionsList = new ArrayList<>();
    private TreatmentPrescription treatmentPrescription = new TreatmentPrescription();
   
    @PostConstruct
    private void init(){
        prescriptionsList = commonService.prescriptionsListByDiagnosis(selectedDiagnosis);
    }
    
    public void selectPetAction(){
        selectedPet = petSeachController.getSelectedPet();
    }
    
    public void selectDiagnosisAction() {
        prescriptionsList = commonService.prescriptionsListByDiagnosis(selectedDiagnosis);
    }
    
    public void saveTreatment(){
        double totalCost = 0.0;
        try {
            if(null == selectedPet){
                Msg.genericError("Please select Pet to vaccinate");
                return;
            }
            treatment.setDiagnosis(selectedDiagnosis);
            treatment.setPet(selectedPet);
            if(crudService.save(treatment) != null){
                for(Prescription prescription : prescriptionsList) {
                    totalCost += prescription.getPrice();
                    treatmentPrescription.setTreatment(treatment);
                    treatmentPrescription.setPrescription(prescription.getId());
                    crudService.save(treatmentPrescription);
                }
                treatment.setTotalCost(totalCost);
                crudService.save(treatment);
                Msg.successSave();
            }
        } catch (Exception e) {
            Msg.failedSave();
            e.printStackTrace();
        }
    }
    
    public void selectTreatment(Treatment selectedTreatment){
        this.treatment = selectedTreatment;
    }
    
    public void deleteTreatment(Treatment selectedTreatment){
        try {
            if(crudService.delete(treatment, false)){
                Msg.successDelete();
            }
        } catch (Exception e) {
            Msg.failedDelete();
            e.printStackTrace();
        }
    }
    
    public void clear() {
        treatment = new Treatment();
        prescriptionsList.clear();
        selectedDiagnosis = null;
        selectedPet = null;
    }

    public Pet getSelectedPet()
    {
        return selectedPet;
    }

    public void setSelectedPet(Pet selectedPet)
    {
        this.selectedPet = selectedPet;
    }

    public Diagnosis getSelectedDiagnosis()
    {
        return selectedDiagnosis;
    }

    public void setSelectedDiagnosis(Diagnosis selectedDiagnosis)
    {
        this.selectedDiagnosis = selectedDiagnosis;
    }

    public Treatment getTreatment()
    {
        return treatment;
    }

    public void setTreatment(Treatment treatment)
    {
        this.treatment = treatment;
    }

    public List<Treatment> getTreatmentsList()
    {
//        treatmentsList = commonService.petTreatmentHistoryByDiagnosis(selectedPet, DiagnosisCategory.VACCINATION);
        return treatmentsList;
    }

    public void setTreatmentsList(List<Treatment> treatmentsList)
    {
        this.treatmentsList = treatmentsList;
    }

    public List<Prescription> getPrescriptionsList()
    {
        return prescriptionsList;
    }

    public void setPrescriptionsList(List<Prescription> prescriptionsList)
    {
        this.prescriptionsList = prescriptionsList;
    }
    
}

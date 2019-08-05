/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.Diagnosis;
import com.thekeigroup.petboss.entities.Pet;
import com.thekeigroup.petboss.entities.Prescription;
import com.thekeigroup.petboss.entities.Product;
import com.thekeigroup.petboss.entities.Treatment;
import com.thekeigroup.petboss.entities.TreatmentPrescription;
import com.thekeigroup.petboss.services.CommonService;
import com.thekeigroup.petboss.services.CrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ICSGH-BILLY
 */
@Named(value = "treatmentController")
@SessionScoped
public class TreatmentController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject
    private CommonService commonService;
    @Inject
    private PetSeachController petSeachController;
    @Inject
    private ProductSearchController productSearchController;
    @Inject
    private ReportController reportController;

    private Treatment treatment = new Treatment();
    private List<Treatment> treatmentsList = new ArrayList<>();
    private Pet selectedPet;
    private Diagnosis selectedDiagnosis;
    private List<Prescription> prescriptionsList = new ArrayList<>();
    private TreatmentPrescription treatmentPrescription = new TreatmentPrescription();
    private Date today = new Date();
    private boolean showAddMoreDialog = false;
    private List<Prescription> addMorePrescriptionsList = new ArrayList<>();
    private Product selectedProduct;
    private String dosageQuantity;
    private double price = 0.00;
    private double totalCost = 0.00;
    

    public void selectPetAction() {
        selectedPet = petSeachController.getSelectedPet();
        
    }
    
    public void selectProductAction(){
        selectedProduct = productSearchController.getSelectedProduct();
        price = selectedProduct.getUnitPrice();
        dosageQuantity = selectedProduct.getDosageQty();
    }

    public void selectDiagnosisAction() {
        prescriptionsList = commonService.prescriptionsListByDiagnosis(selectedDiagnosis);
        
        totalCost = prescriptionsList.stream().mapToDouble(v -> v.getPrice()).sum();
    }

    public void diagnosis() {
        try {
            if (null == selectedPet) {
                Msg.genericError("Please select Pet to diagnose");
                return;
            }
            treatment.setPet(selectedPet);
            treatment.setValueDate(new Date());
            if (crudService.save(treatment) != null) {
                //render treatment input form
                Msg.info("Pet readings saved successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.failedSave();
        }
    }

    public void closeInputForm() {
        clear();
    }

    public void saveTreatment() {
        try {
            if (null == selectedPet) {
                Msg.genericError("Please select Pet to diagnose");
                return;
            }
            if (null == selectedDiagnosis) {
                Msg.genericError("Select diagnosis for treatment");
                return;
            }

            treatment.setDiagnosis(selectedDiagnosis);
            if (crudService.save(treatment) != null) {
                for (Prescription prescription : prescriptionsList) {
                    treatmentPrescription.setTreatment(treatment);
                    treatmentPrescription.setProduct(prescription.getProduct());
                    totalCost += treatmentPrescription.getPrice();
                    crudService.save(treatmentPrescription);
                }
                //update total cost of treatment
                treatment.setTotalCost(totalCost);
                crudService.save(treatment);
                Msg.successSave();
            }
        } catch (Exception e) {
            Msg.failedSave();
            e.printStackTrace();
        }
    }
    
    public void showDialog()
    {
        if(null == selectedDiagnosis)
        {
            Msg.genericError("Please select a diagnosis");
            return;
        }
        showAddMoreDialog = true;
    }
    
    //adds new precription to addmoreprescriptions list
    public void addToPrescriptionList()
    {
        try {
            if(null == selectedProduct){
                Msg.error("Please select product");
                return;
            }
            Prescription prescription = new Prescription();
            prescription.setProduct(selectedProduct);
            prescription.setDiagnosis(selectedDiagnosis);
            prescription.setDosageQuantity(dosageQuantity);
            prescription.setPrice(price);
            
            addMorePrescriptionsList.add(prescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //adds the addmoreprescription list to main diagnosis prescription list
    public void savePrescriptionList()
    {
        try {
            if(!addMorePrescriptionsList.isEmpty()){
                prescriptionsList.addAll(addMorePrescriptionsList);
                
                totalCost = prescriptionsList.stream().mapToDouble(v -> v.getPrice()).sum();
                closeDialog();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void closeDialog()
    {
        try {
             //close dialog and clear list
                showAddMoreDialog = false;
                selectedProduct = null;
                price = 0.0;
                dosageQuantity = "";
                clearAddMoreList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clearAddMoreList()
    {
         addMorePrescriptionsList.clear();
    }
    
    public void printReceipt(Treatment treatment)
    {
        
    }

    public void selectTreatment(Treatment selectedTreatment) {
        this.treatment = selectedTreatment;
    }

    public void deleteTreatment(Treatment selectedTreatment) {
        try {
            if (crudService.delete(treatment, false)) {
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

    public Pet getSelectedPet() {
        return selectedPet;
    }

    public void setSelectedPet(Pet selectedPet) {
        this.selectedPet = selectedPet;
    }

    public Diagnosis getSelectedDiagnosis() {
        return selectedDiagnosis;
    }

    public void setSelectedDiagnosis(Diagnosis selectedDiagnosis) {
        this.selectedDiagnosis = selectedDiagnosis;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public List<Treatment> getTreatmentsList() {
        treatmentsList = commonService.petTreatmentHistoryByDiagnosis(selectedPet, null);
        return treatmentsList;
    }

    public void setTreatmentsList(List<Treatment> treatmentsList) {
        this.treatmentsList = treatmentsList;
    }

    public List<Prescription> getPrescriptionsList() {
        return prescriptionsList;
    }

    public void setPrescriptionsList(List<Prescription> prescriptionsList) {
        this.prescriptionsList = prescriptionsList;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public boolean isShowAddMoreDialog() {
        return showAddMoreDialog;
    }

    public void setShowAddMoreDialog(boolean showAddMoreDialog) {
        this.showAddMoreDialog = showAddMoreDialog;
    }

    public List<Prescription> getAddMorePrescriptionsList() {
        return addMorePrescriptionsList;
    }

    public void setAddMorePrescriptionsList(List<Prescription> addMorePrescriptionsList) {
        this.addMorePrescriptionsList = addMorePrescriptionsList;
    }

    public String getDosageQuantity() {
        return dosageQuantity;
    }

    public void setDosageQuantity(String dosageQuantity) {
        this.dosageQuantity = dosageQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }
    
    
}

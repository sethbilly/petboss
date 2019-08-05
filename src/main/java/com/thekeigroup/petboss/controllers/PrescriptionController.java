/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.Diagnosis;
import com.thekeigroup.petboss.entities.Prescription;
import com.thekeigroup.petboss.entities.Product;
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
@Named(value = "prescriptionController")
@SessionScoped
public class PrescriptionController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject 
    private CommonService commonService;
    @Inject
    private DiagnosisSearchController diagnosisSearchController;
    @Inject
    private ProductController productController;
    
    private Prescription prescription = new Prescription();
    private List<Prescription> prescriptionsList = new ArrayList<>();
    private Diagnosis selectedDiagnosis;
    private List<Product> productsList = new ArrayList<>();
    private Product product;
    
    
    public void selectDiagnosisAction() {
        selectedDiagnosis = diagnosisSearchController.getSelectedDiagnosis();
        //load prescriptions for selected diagnosis
        prescriptionsList = commonService.prescriptionsListByDiagnosis(selectedDiagnosis);
    }
    
    public void savePrescription(){
        try {
            if(null == selectedDiagnosis)
            {
                Msg.genericError("Please select a diagnosis to add drugs to");
                return;
            }
            if(productsList.isEmpty())
            {
                Msg.genericError("Please at least product for the selected diagnosis");
                return;
            }
            prescription.setDiagnosis(selectedDiagnosis);
            for(Product product : productsList)
            {
                prescription.setProduct(product);
                prescription.setPrice(product.getUnitPrice());
                prescription.setDosageQuantity(product.getDosageQty());
                crudService.save(prescription);
            }
            Msg.successSave();
            clear();
        } catch (Exception e) {
            Msg.failedSave();
            e.printStackTrace();
        }
    }
    
    public void clear()
    {
        prescription = new Prescription();
        selectedDiagnosis = null;
        productsList.clear();
    }
    
    public void selectPrescription(Prescription selectedPrescription){
        this.prescription = selectedPrescription;
        product = crudService.find(Product.class, selectedPrescription.getProduct().getId());
        product.setDosageQty(selectedPrescription.getDosageQuantity());
        product.setUnitPrice(selectedPrescription.getPrice());
        productsList.add(product);
        selectedDiagnosis = selectedPrescription.getDiagnosis();
    }
    
    public void deletePrescription(Prescription selectedPrescription){
        try {
            if(crudService.delete(selectedPrescription, false)){
                Msg.successDelete();
            }
        } catch (Exception e) {
            Msg.failedDelete();
            e.printStackTrace();
        }
    }
    
    public void addProduct() {
        if(!productsList.contains(productController.getSelectedTblProduct())){
            productsList.add(productController.getSelectedTblProduct());
        }
    }
    
    public void removeProduct(Product selectedProduct)
    {
        productsList.remove(selectedProduct);
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public List<Prescription> getPrescriptionsList() {
        prescriptionsList = commonService.getPrescriptionsList();
        return prescriptionsList;
    }

    public void setPrescriptionsList(List<Prescription> prescriptionsList) {
        this.prescriptionsList = prescriptionsList;
    }

    public Diagnosis getSelectedDiagnosis()
    {
        return selectedDiagnosis;
    }

    public void setSelectedDiagnosis(Diagnosis selectedDiagnosis)
    {
        this.selectedDiagnosis = selectedDiagnosis;
    }

    public List<Product> getProductsList()
    {
        return productsList;
    }

    public void setProductsList(List<Product> productsList)
    {
        this.productsList = productsList;
    }
    
    
}

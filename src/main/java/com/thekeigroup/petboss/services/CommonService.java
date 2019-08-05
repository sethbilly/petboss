/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.services;

import com.latlab.common.jpa.QryHelper;
import com.thekeigroup.petboss.constants.BookingType;
import com.thekeigroup.petboss.entities.DiagnosisCategory;
import com.thekeigroup.petboss.constants.StaffCategory;
import com.thekeigroup.petboss.entities.HouseCall;
import com.thekeigroup.petboss.entities.Client;
import com.thekeigroup.petboss.entities.ClientTransaction;
import com.thekeigroup.petboss.entities.Diagnosis;
import com.thekeigroup.petboss.entities.Pet;
import com.thekeigroup.petboss.entities.PetBoarding;
import com.thekeigroup.petboss.entities.Prescription;
import com.thekeigroup.petboss.entities.Product;
import com.thekeigroup.petboss.entities.ProductForm;
import com.thekeigroup.petboss.entities.Staff;
import com.thekeigroup.petboss.entities.Treatment;
import com.thekeigroup.petboss.entities.TreatmentPrescription;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author seth
 */
@Stateless
public class CommonService 
{
    @Inject
    private CrudService crudService;
    
    public List<Pet> getPetsList(){
        return crudService.findAll(Pet.class, false);
    }
    
    public List<Pet> getClientPetList(Client client){
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Pet.class);
            qryHelper.addObjectParam(Pet._owner, client);
            qryHelper.addObjectParam(Pet._deleted, false);
            qryHelper.orderByAsc(Pet._name);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Client> getClientsList(){
       try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Client.class);
            qryHelper.addObjectParam(Client._deleted, false);
            qryHelper.orderByAsc(Client._surname);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Diagnosis> getDiagnosisList(){
        return crudService.findAll(Diagnosis.class, false);
    }
    
    public List<DiagnosisCategory> getDiagnosisCategoryList(){
        return crudService.findAll(DiagnosisCategory.class, false);
    }
    
        public List<Diagnosis> getDiagnosisByCategory(DiagnosisCategory diagnosisCategory) {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Diagnosis.class);
            qryHelper.addObjectParam(Diagnosis._diagnosisCategory, diagnosisCategory);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Prescription> getPrescriptionsList(){
        return crudService.findAll(Prescription.class, false);
    }
    
    public List<Client> getClientListByAttribute(Client clientQP){
        try {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Client.class);
            qryHelper.addStringQryParam(Client._surname, clientQP.getSurname(), QryHelper.ComparismCriteria.LIKE, QryHelper.IncludeCriteria.OR);
            qryHelper.addStringQryParam(Client._otherNames, clientQP.getOtherNames(), QryHelper.ComparismCriteria.LIKE, QryHelper.IncludeCriteria.OR);
            qryHelper.addStringQryParam(Client._mobileNumber, clientQP.getMobileNumber(), QryHelper.ComparismCriteria.LIKE);
            
            return qryHelper.buildQry().getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    
     public List<Pet> getPetListByAttribute(Pet petQP){
        try {

            String qry = "SELECT e FROM " + Pet.class.getCanonicalName() + " e " +
                    "WHERE e.chipCode LIKE '%" + petQP.getChipCode() + "%' " +
                    "OR e.bookCode LIKE '%" + petQP.getBookCode() + "%' " +
                    "OR e.name LIKE '%" + petQP.getName() + "%' ";

            return crudService.getEm().createQuery(qry).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
     
     public List<Product> getProductsListByAttribute(Product productQP){
        try {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Product.class);
            qryHelper.addStringQryParam(Product._productName, productQP.getProductName(), QryHelper.ComparismCriteria.LIKE);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
     
     public List<Diagnosis> getDiagnosisListByAttribute(Diagnosis diagnosisQP){
        try {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Diagnosis.class);
            qryHelper.addStringQryParam(Diagnosis._diagnosisName, diagnosisQP.getDiagnosisName(), QryHelper.ComparismCriteria.LIKE);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
     
     public List<Prescription> prescriptionsListByDiagnosis(Diagnosis diagnosisQP){
        try {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Prescription.class);
            qryHelper.addObjectParam(Prescription._diagnosis, diagnosisQP);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<PetBoarding> getPetBoardingList(Pet selectedPet) {
        try
        {
            
            QryHelper qryHelper = new QryHelper(crudService.getEm(), PetBoarding.class);
            if(null != selectedPet)
            {
                qryHelper.addObjectParam(PetBoarding._pet, selectedPet);
            }
            qryHelper.orderByAsc(PetBoarding._createdDate);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Product> getProductsList() {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Product.class);
            qryHelper.orderByAsc(Product._productName);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Treatment> petTreatmentHistory(Pet selectedPet) {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Treatment.class);
            qryHelper.addObjectParam(Treatment._pet, selectedPet);
            qryHelper.orderByDesc(Treatment._createdDate);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Treatment> petTreatmentHistoryByDiagnosis(Pet selectedPet, DiagnosisCategory diagnosisCategory) {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Treatment.class);
            qryHelper.addObjectParam(Treatment._pet, selectedPet);
            if(diagnosisCategory != null){
                qryHelper.addObjectParam(Treatment._diagnosis_diagnosisCategory, diagnosisCategory);
            }
            qryHelper.orderByDesc(Treatment._createdDate);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<ClientTransaction> clientTransactionsList(Client client) {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), ClientTransaction.class);
            qryHelper.addObjectParam(ClientTransaction._client, client);
            qryHelper.orderByDesc(ClientTransaction._createdDate);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<HouseCall> clientHouseCallList(Client client) {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), HouseCall.class);
            qryHelper.addObjectParam(HouseCall._client, client);
            qryHelper.addObjectParam(HouseCall._bookingType, BookingType.HOUSE_CALL);
            qryHelper.orderByDesc(HouseCall._bookingSlot);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<ProductForm> getProductFormList(){
        try
        {
            return crudService.findAll(ProductForm.class, false);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    public List<Staff> getStaffList(StaffCategory staffCategory){
        try {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), Staff.class);
            if(null != staffCategory){
                qryHelper.addObjectParam(Staff._statffCategory, staffCategory);
            }
            return qryHelper.buildQry().getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
    
    
    public List<TreatmentPrescription> treatmentPrescriptionList(Treatment treatment)
    {
        try
        {
            QryHelper qryHelper = new QryHelper(crudService.getEm(), TreatmentPrescription.class);
            qryHelper.addObjectParam(TreatmentPrescription._treatment, treatment);
            return qryHelper.buildQry().getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}

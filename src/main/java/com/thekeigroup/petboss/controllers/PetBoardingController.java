/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.latlab.common.model.DateRange;
import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.Client;
import com.thekeigroup.petboss.entities.Pet;
import com.thekeigroup.petboss.entities.PetBoarding;
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
@Named(value = "petBoardingController")
@SessionScoped
public class PetBoardingController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject 
    private CommonService commonService;
    @Inject PetSeachController petSeachController;

    private PetBoarding petBoarding = new PetBoarding();
    private List<Pet> petsList = new ArrayList<>();
    private List<PetBoarding> petBoardingList = new ArrayList<>();
    private Client selectedClient;
    private Pet selectedPet;
    private Date fromDate, toDate;
    private DateRange dateRange = new DateRange();
    
    public void selectPet(){
        selectedPet = petSeachController.getSelectedPet();
    }

    public void savePetBoarding() {
        try {
            if(null == selectedPet)
            {
                Msg.genericError("Please select a Pet to house");
                return;
            }
            if(petBoarding.getFromDate() == null || petBoarding.getToDate() == null)
            {
                Msg.genericError("Please select duration for boarding pet");
                return;
            }
            petBoarding.setPet(selectedPet);
            if (crudService.save(petBoarding) != null) {
                Msg.successSave();
                clear();
            }

        } catch (Exception e) {
            Msg.failedSave();
            e.printStackTrace();
        }
    }
    
    public void clear(){
        try {
            petBoarding = new PetBoarding();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectPetBoarding(PetBoarding selectedPetBoarding) {
        this.petBoarding = selectedPetBoarding;
    }

    public void deletePetBoarding(PetBoarding selectedPetBoarding) {
        try {
            if (crudService.delete(selectedPetBoarding, false)) {
                Msg.successDelete();
            }
        } catch (Exception e) {
            Msg.failedDelete();
            e.printStackTrace();
        }
    }

    public PetBoarding getPetBoarding()
    {
        return petBoarding;
    }

    public void setPetBoarding(PetBoarding petBoarding)
    {
        this.petBoarding = petBoarding;
    }

    public Client getSelectedClient()
    {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient)
    {
        this.selectedClient = selectedClient;
    }

    public Pet getSelectedPet()
    {
        return selectedPet;
    }

    public void setSelectedPet(Pet selectedPet)
    {
        this.selectedPet = selectedPet;
    }

    public List<Pet> getPetsList() {
        petsList = commonService.getPetsList();
        return petsList;
    }

    public void setPetsList(List<Pet> petsList) {
        this.petsList = petsList;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    public List<PetBoarding> getPetBoardingList()
    {
        return petBoardingList = commonService.getPetBoardingList(selectedPet);
    }

    public void setPetBoardingList(List<PetBoarding> petBoardingList)
    {
        this.petBoardingList = petBoardingList;
    }

    public DateRange getDateRange()
    {
        return dateRange;
    }

    public void setDateRange(DateRange dateRange)
    {
        this.dateRange = dateRange;
    }
    
    
}

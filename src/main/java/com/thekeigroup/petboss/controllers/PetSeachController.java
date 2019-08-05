/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.thekeigroup.petboss.entities.Pet;
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
@Named(value = "petSearchController")
@SessionScoped
public class PetSeachController implements Serializable{
    
    @Inject private CommonService commonService;
    private List<Pet> petList = new ArrayList<>();
    private Pet selectedPet;
    private String searchText;
    
    public void searchPet(){
        Pet petQP = new Pet();
        petQP.setChipCode(searchText);
        petQP.setName(searchText);
        petQP.setBookCode(searchText);
        
        petList = commonService.getPetListByAttribute(petQP);
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public Pet getSelectedPet() {
        return selectedPet;
    }

    public void setSelectedPet(Pet selectedPet) {
        this.selectedPet = selectedPet;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    
    
}

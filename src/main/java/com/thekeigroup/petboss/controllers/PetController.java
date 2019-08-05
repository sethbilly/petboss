/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.google.common.base.Strings;
import com.latlab.mojarra.jsf.JsfUtil;
import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.Client;
import com.thekeigroup.petboss.entities.Pet;
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
@Named(value = "petController")
@SessionScoped
public class PetController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject
    private CommonService commonService;

    private Pet pet = new Pet();
    private List<Pet> petsList = new ArrayList<>();
    private Client selectedClient = null;

    public void savePet() {
        try {
            if (selectedClient == null) {
                Msg.error("Please select a client");
                return;
            }
            if(Strings.isNullOrEmpty(pet.getBookCode()) || Strings.isNullOrEmpty(pet.getName()))
            {
                Msg.genericError("Pet book or name missing");
                return;
            }

            pet.setOwner(selectedClient);
            if (crudService.save(pet) != null) {
                Msg.successSave();
                clear();
            }

        } catch (Exception e) {
            Msg.failedSave();
            e.printStackTrace();
        }
    }

    public void clear() {
        try {
            pet = new Pet();
            JsfUtil.resetViewRoot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectPet(Pet selectedPet) {
        this.pet = selectedPet;
    }

    public void deletePet(Pet selectedPet) {
        try {
            if (crudService.delete(pet, false)) {
                Msg.successDelete();
            }
        } catch (Exception e) {
            Msg.failedDelete();
            e.printStackTrace();
        }
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Pet> getPetsList() {
        petsList = commonService.getClientPetList(selectedClient);
        return petsList;
    }

    public void setPetsList(List<Pet> petsList) {
        this.petsList = petsList;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

}

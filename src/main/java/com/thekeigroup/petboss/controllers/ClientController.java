/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.google.common.base.Strings;
import com.latlab.common.model.RandomNumbers;
import com.latlab.mojarra.jsf.JsfUtil;
import com.latlab.mojarra.jsf.Msg;
import com.stately.common.utils.StringUtil;
import com.thekeigroup.petboss.entities.Client;
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
@Named(value = "clientController")
@SessionScoped
public class ClientController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject
    private CommonService commonService;
    @Inject
    private PetController petController;

    private Client client = new Client();
    private List<Client> clientsList = new ArrayList<>();
    private boolean showPetRegistrationDialog = false;
    private String clientCode = null;

    public ClientController() {
        generateClientCode();
    }

    private String generateClientCode() {
        return clientCode = RandomNumbers.generateRandomNumber();
    }

    public void saveClient() {
        try {
            if(Strings.isNullOrEmpty(client.getSurname()) ||Strings.isNullOrEmpty(client.getTelephoneNumber()))
            {
                Msg.genericError("Client required field missing");
                return;
            }
            client.setClientCode(clientCode);
            if (crudService.save(client) != null) {
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
            client = new Client();
            generateClientCode();
            JsfUtil.resetViewRoot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectClient(Client selectedClient) {
        this.client = selectedClient;
        if (StringUtil.isNullOrEmpty(selectedClient.getClientCode())) {
            generateClientCode();
            client.setClientCode(clientCode);
        } else {
            clientCode = selectedClient.getClientCode();

        }
    }

    public void deleteClient(Client selectedClient) {
        try {
            if (!commonService.getClientPetList(selectedClient).isEmpty()) {
                Msg.error("Sorry cannot delete. Client has registered pet(s)");
                return;
            }
            if (crudService.delete(selectedClient, false)) {
                Msg.successDelete();
            }
        } catch (Exception e) {
            Msg.failedDelete();
            e.printStackTrace();
        }
    }

    public void viewClientPet(Client selectedClient) {
        try {
            showPetRegistrationDialog = true;
            petController.setSelectedClient(selectedClient);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeDialog() {
        showPetRegistrationDialog = false;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClientsList() {
        clientsList = commonService.getClientsList();
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public boolean isShowPetRegistrationDialog() {
        return showPetRegistrationDialog;
    }

    public void setShowPetRegistrationDialog(boolean showPetRegistrationDialog) {
        this.showPetRegistrationDialog = showPetRegistrationDialog;
    }

    public String getClientCode() {

        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

}

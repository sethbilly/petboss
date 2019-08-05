/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.thekeigroup.petboss.entities.Client;
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
@Named(value = "clientSearchController")
@SessionScoped
public class ClientSearchController implements Serializable {

    @Inject
    private CommonService commonService;
    private List<Client> clientsList = new ArrayList<>();
    private Client selectedClient;
    private String searchText;

    public List<Client> searchClientByAttribute() {
        Client clientQP = new Client();
        clientQP.setOtherNames(searchText);
        clientQP.setSurname(searchText);
        clientQP.setMobileNumber(searchText);

        return commonService.getClientListByAttribute(clientQP);
    }
    
    public void searchClient(){
        Client clientQP = new Client();
        clientQP.setOtherNames(searchText);
        clientQP.setSurname(searchText);
        clientQP.setMobileNumber(searchText);

        clientsList =  commonService.getClientListByAttribute(clientQP);
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    
}

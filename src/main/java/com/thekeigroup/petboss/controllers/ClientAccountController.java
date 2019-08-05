/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.Client;
import com.thekeigroup.petboss.entities.ClientTransaction;
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
@Named(value = "clientAccountController")
@SessionScoped
public class ClientAccountController implements Serializable {
    @Inject
    private CommonService commonService;
    @Inject
    private ClientSearchController clientSearchController;
    
    private Client selectedClient;
    private List<ClientTransaction> clientTransactionList = new ArrayList<>();
    
    public void selectClient()
    {
        selectedClient = clientSearchController.getSelectedClient();
        //fetch client transactions
        commonService.clientTransactionsList(selectedClient);
    }

    public List<ClientTransaction> getClientTransactionList()
    {
        return clientTransactionList;
    }

    public void setClientTransactionList(List<ClientTransaction> clientTransactionList)
    {
        this.clientTransactionList = clientTransactionList;
    }
    
    
}

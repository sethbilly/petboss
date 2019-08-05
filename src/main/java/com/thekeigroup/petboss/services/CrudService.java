/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.services;

import com.latlab.common.jpa.CrudController;
import com.latlab.common.jpa.Enviroment;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author seth
 */
@Stateless
public class CrudService extends CrudController
{
    @PersistenceContext(unitName = "petbossPU")
    private EntityManager em;
    
    @PostConstruct
    private void init(){
        setEm(em);
        setEnviroment(Enviroment.JAVA_EE);
    }
}

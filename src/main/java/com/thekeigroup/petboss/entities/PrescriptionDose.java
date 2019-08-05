/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.entities;

import com.latlab.common.jpa.CommonModel;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author ICSGH-BILLY
 */
@MappedSuperclass
public class PrescriptionDose extends CommonModel
{
    @Column(name = "amount")
    private double amount;
    
    
}

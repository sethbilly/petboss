/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.constants;

import com.latlab.common.constants.EnumResolvable;

/**
 *
 * @author ICSGH-BILLY
 */
public enum StaffCategory implements EnumResolvable
{
    DOCTOR("Doctor", "DOCTOR"),
    OTHERS("Others", "OTHERS");
    
    private String label, code;

    private StaffCategory(String label, String code)
    {
        this.label = label;
        this.code = code;
    }
    
    

    @Override
    public String getLabel()
    {
        return label;
    }

    @Override
    public String getCode()
    {
        return code;
    }

    @Override
    public String toString()
    {
        return label;
    }
    
    
}

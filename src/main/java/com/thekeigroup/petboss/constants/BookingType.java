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
public enum BookingType implements EnumResolvable
{
    HOUSE_CALL;
    
    private String label,code;
    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getCode() {
        return code;
    }
}

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
public enum PetType implements EnumResolvable
{
   DOG("Dog", "DOG"),
   CAT("Cat", "CAT"),
   BIRD("Bird", "BIRD"),
   FISH("Fish", "FISH"),
   REPTILE("Reptile", "REPTILE"),
   FERRET("Ferret", "FERRET"),
   EXOTIC("Exotic", "EXOTIC"),
   HORSE("Horse", "HORSE"),
   RABBIT("Rabbit", "RABBIT");
        
    private String label;
    private String code;

    private PetType(String label, String code)
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
        return label ;
    }
    
}

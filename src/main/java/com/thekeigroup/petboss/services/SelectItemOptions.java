/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.services;

import com.latlab.common.constants.Gender;
import com.latlab.common.constants.Quarter;
import com.thekeigroup.petboss.constants.BookingType;
import com.thekeigroup.petboss.constants.PetType;
import com.thekeigroup.petboss.entities.DiagnosisCategory;
import com.thekeigroup.petboss.constants.StaffCategory;
import com.thekeigroup.petboss.entities.Diagnosis;
import com.thekeigroup.petboss.entities.ProductForm;
import com.thekeigroup.petboss.entities.Staff;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author seth
 */
@Named(value = "selectItemOptions")
@ApplicationScoped
public class SelectItemOptions implements Serializable {

    @Inject
    private CommonService commonService;

    public List<BookingType> getBookingTypesSelectItems() {
        return Arrays.asList(BookingType.values());
    }

//    public List<Diagnosis> getGeneralDiagnosisSelectItems() {
//        return commonService.getDiagnosisByCategory(DiagnosisCategory.GENERAL_TREATMENTS);
//    }

    public List<Diagnosis> getDiagnosisSelectItems() {
        return commonService.getDiagnosisList();
    }

//    public List<Diagnosis> getOtherDiagnosisSelectItems() {
//        return commonService.getDiagnosisByCategory(DiagnosisCategory.OTHERS);
//    }
//
//    public List<Diagnosis> getVacciDiagnosisSelectItems() {
//        return commonService.getDiagnosisByCategory(DiagnosisCategory.VACCINATION);
//    }
//
//    public List<Diagnosis> getDewormDiagnosisSelectItems() {
//        return commonService.getDiagnosisByCategory(DiagnosisCategory.DEWORMING);
//    }

    public List<PetType> getPetTypesSelectItems() {
        return Arrays.asList(PetType.values());
    }

//    public List<DiagnosisCategory> getDiagnosisCatSelectItems() {
//        return Arrays.asList(DiagnosisCategory.values());
//    }
    
    public List<DiagnosisCategory> getDiagnosisCatSelectItems() {
        return commonService.getDiagnosisCategoryList();
    }

    public List<Gender> getGenderSelectItems() {
        return Arrays.asList(Gender.MALE, Gender.FEMALE);
    }

    public List<ProductForm> getProductFormSelectItems() {
        return commonService.getProductFormList();
    }

    public List<Quarter> getYearQuarterSelectItems() {
        return Arrays.asList(Quarter.values());
    }
    
    public List<Staff> getDoctorSelectItems(){
        return commonService.getStaffList(StaffCategory.DOCTOR);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.thekeigroup.petboss.entities.Treatment;
import com.thekeigroup.petboss.entities.TreatmentPrescription;
import com.thekeigroup.petboss.models.TreatmentReceiptDetails;
import com.thekeigroup.petboss.services.CommonService;
import com.thekeigroup.petboss.utils.ReportFiles;
import com.thekeigroup.petboss.utils.ReportInputParam;
import com.thekeigroup.petboss.utils.ReportManager;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ICSGH-BILLY
 */
@Named
@RequestScoped
public class ReportController extends ReportManager implements Serializable
{
    @Inject private CommonService commonService;
    
    private ReportInputParam reportInputParam = new ReportInputParam();

    public ReportInputParam getReportInputParam()
    {
        return reportInputParam;
    }

    public void setReportInputParam(ReportInputParam reportInputParam)
    {
        this.reportInputParam = reportInputParam;
    }
    
    
    public void printTreatmentReceipt(Treatment treatment)
    {
        try
        {
            List<TreatmentPrescription> treatmentPrescriptionsList = commonService.treatmentPrescriptionList(treatment);
            
            TreatmentReceiptDetails receiptDetails = new TreatmentReceiptDetails();
            receiptDetails.convert(treatment, treatmentPrescriptionsList);
            
            addParam("billingDate", receiptDetails.getBillingDate());
            addParam("nextAppointmentDate", receiptDetails.getNextAppointmentDate());
            addParam("diagnosis", receiptDetails.getDiagnosis());
            addParam("printedBy", "");
            addParam("receiptNumber", "");
            addParam("amountPaid", "");
            
            showReport(receiptDetails.getPrescriptionDetailsList(), getClass().getResourceAsStream(ReportFiles._receipt));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}

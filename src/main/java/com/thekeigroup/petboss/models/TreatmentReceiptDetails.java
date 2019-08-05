/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.models;

import com.thekeigroup.petboss.entities.Treatment;
import com.thekeigroup.petboss.entities.TreatmentPrescription;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author INF-BILLY
 */
public class TreatmentReceiptDetails implements Serializable
{
    private String diagnosis;
    private String receiptNumber;
    private Date treatmentDate;
    private Date nextAppointmentDate;
    private Date billingDate;
    private String printedBy;
    private double totalCost;
    private double amountPaid;
    
    private List<PrescriptionDetails> prescriptionDetailsList = new LinkedList<>();
    
    public void convert(Treatment treatment, List<TreatmentPrescription> treatmentPrescriptionsList)
    {
        try
        {
            this.diagnosis = treatment.getDiagnosis().getDiagnosisName();
            this.nextAppointmentDate = treatment.getNextTreatmentDate();
            this.billingDate = treatment.getCreatedDate();
            
            
            if(!treatmentPrescriptionsList.isEmpty())
            {
                for(TreatmentPrescription tp : treatmentPrescriptionsList)
                {
                    PrescriptionDetails pd = new PrescriptionDetails();
                    pd.setDosage(tp.getDosageQuantity());
                    pd.setPrescription(tp.getProduct().getProductName());
                    pd.setItemAmount(tp.getPrice());
                    pd.setPrice(tp.getPrice());
                    
                    prescriptionDetailsList.add(pd);
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public String getReceiptNumber()
    {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber)
    {
        this.receiptNumber = receiptNumber;
    }

    public Date getTreatmentDate()
    {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate)
    {
        this.treatmentDate = treatmentDate;
    }

    public Date getNextAppointmentDate()
    {
        return nextAppointmentDate;
    }

    public void setNextAppointmentDate(Date nextAppointmentDate)
    {
        this.nextAppointmentDate = nextAppointmentDate;
    }

    public Date getBillingDate()
    {
        return billingDate;
    }

    public void setBillingDate(Date billingDate)
    {
        this.billingDate = billingDate;
    }

    public String getPrintedBy()
    {
        return printedBy;
    }

    public void setPrintedBy(String printedBy)
    {
        this.printedBy = printedBy;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }

    public double getAmountPaid()
    {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid)
    {
        this.amountPaid = amountPaid;
    }

    public List<PrescriptionDetails> getPrescriptionDetailsList()
    {
        return prescriptionDetailsList;
    }

    public void setPrescriptionDetailsList(List<PrescriptionDetails> prescriptionDetailsList)
    {
        this.prescriptionDetailsList = prescriptionDetailsList;
    }
    
    
}

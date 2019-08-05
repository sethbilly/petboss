/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.utils;

import com.latlab.common.constants.Quarter;
import com.latlab.common.model.DateRange;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ICSGH-BILLY
 */
public class ReportInputParam implements Serializable
{
    private Quarter quarter;
    private Date today = new Date();
    private DateRange dateRange = new DateRange(null, today);
    private int year;

    public void setQuarter(Quarter quarter)
    {
        this.quarter = quarter;
    }

    public void setDateRange(DateRange dateRange)
    {
        this.dateRange = dateRange;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public Quarter getQuarter()
    {
        return quarter;
    }

    public DateRange getDateRange()
    {
        return dateRange;
    }

    public Date getToday()
    {
        return today;
    }

    public void setToday(Date today)
    {
        this.today = today;
    }
   
}

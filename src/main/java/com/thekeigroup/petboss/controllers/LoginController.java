/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.thekeigroup.petboss.utils.AppPages;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.omnifaces.util.Faces;

/**
 *
 * @author seth
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController implements Serializable {

    public LoginController()
    {
    }
    
    
    public void logIn() {
        try
        {
           Faces.redirect(Faces.getRequestContextPath() + AppPages.DASHBOARD);
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void logOut() {
        try
        {
            Faces.redirect(Faces.getRequestContextPath() + AppPages.LOGIN);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

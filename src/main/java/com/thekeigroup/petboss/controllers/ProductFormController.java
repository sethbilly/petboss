/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.google.common.base.Strings;
import com.latlab.mojarra.jsf.Msg;
import com.thekeigroup.petboss.entities.Diagnosis;
import com.thekeigroup.petboss.entities.ProductForm;
import com.thekeigroup.petboss.services.CommonService;
import com.thekeigroup.petboss.services.CrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ICSGH-BILLY
 */
@Named(value = "productFormController")
@SessionScoped
public class ProductFormController implements Serializable {

    @Inject
    private CrudService crudService;
    @Inject 
    private CommonService commonService;
    
    private ProductForm productForm = new ProductForm();
    private List<ProductForm> productFormsList = new ArrayList<>();
 
    
    public void saveProductForm(){
        try {
            if(Strings.isNullOrEmpty(productForm.getFormName()))
            {
                Msg.genericError("Product Form Name is required");
                return;
            }
            if(crudService.save(productForm) != null){
                Msg.successSave();
                clear();
            }
        } catch (Exception e) {
            Msg.failedSave();
            e.printStackTrace();
        }
    }
    
    public void selectProductForm(ProductForm selectedProductForm){
        this.productForm = selectedProductForm;
    }
    
    public void deleteProductForm(ProductForm selectedProductForm){
        try {
            if(crudService.delete(selectedProductForm, true)){
                Msg.successDelete();
            }
        } catch (Exception e) {
            Msg.failedDelete();
            e.printStackTrace();
        }
    }
    
    public void clear(){
        productForm = new ProductForm();
    }

    public ProductForm getProductForm()
    {
        return productForm;
    }

    public void setProductForm(ProductForm productForm)
    {
        this.productForm = productForm;
    }

    public List<ProductForm> getProductFormsList()
    {
        return productFormsList = commonService.getProductFormList();
    }

    public void setProductFormsList(List<ProductForm> productFormsList)
    {
        this.productFormsList = productFormsList;
    }

    
}

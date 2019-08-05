/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.google.common.base.Strings;
import com.latlab.mojarra.jsf.Msg;
import com.stately.common.utils.StringUtil;
import com.thekeigroup.petboss.entities.Product;
import com.thekeigroup.petboss.services.CommonService;
import com.thekeigroup.petboss.services.CrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ICSGH-BILLY
 */
@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ProductController.class.getName());

    @Inject
    private CrudService crudService;
    @Inject
    private CommonService commonService;

    private List<Product> productsList = new ArrayList<>();
    private Product product = new Product();
    private UploadedFile coverImageFile;
    private UploadedFile frontImageFile;
    private UploadedFile sideImageFile;
    private String fileName = "";
    private Product selectedTblProduct;
    

    public void saveProduct() {
        try {
            
            if(!product.isSelected())
            {
//                if(!commonService.productExists(product.getProductName()).isEmpty())
//                {
//                    Msg.error("Product already exists");
//                    return;
//                }  
            }
            if(Strings.isNullOrEmpty(product.getProductName()))
            {
                Msg.error("Product name cannot be empty");
                return;
            }
            if (crudService.save(product) != null) {
                Msg.successSave();
                clearForm();
            }

        } catch (Exception e) {
            Msg.failedSave();
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    public void selectProduct(Product selectedProduct) {
        selectedProduct.setSelected(true);
        product = selectedProduct;
    }

    public void deleteProduct(Product selectedProduct) {
        try {
            if (crudService.delete(selectedProduct, false)) {
                Msg.successDelete();
            }

        } catch (Exception e) {
            Msg.failedDelete();
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    public void clearForm() {
        product = new Product();
    }
    
    public void uploadCoverImage(){
        if(null == coverImageFile){
            return;
        }
    }
    
    public void uploadFrontImage(){
        
    }
    
    public void uploadSideImage(){
        
    }

    public List<Product> getProductsList() {
        productsList = new ArrayList<>(commonService.getProductsList());
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UploadedFile getCoverImageFile() {
        return coverImageFile;
    }

    public void setCoverImageFile(UploadedFile coverImageFile) {
        this.coverImageFile = coverImageFile;
    }

    public UploadedFile getFrontImageFile() {
        return frontImageFile;
    }

    public void setFrontImageFile(UploadedFile frontImageFile) {
        this.frontImageFile = frontImageFile;
    }

    public UploadedFile getSideImageFile() {
        return sideImageFile;
    }

    public void setSideImageFile(UploadedFile sideImageFile) {
        this.sideImageFile = sideImageFile;
    }

    public Product getSelectedTblProduct()
    {
        return selectedTblProduct;
    }

    public void setSelectedTblProduct(Product selectedTblProduct)
    {
        this.selectedTblProduct = selectedTblProduct;
    }
    
    
}

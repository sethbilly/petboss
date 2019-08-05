/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thekeigroup.petboss.controllers;

import com.thekeigroup.petboss.entities.Product;
import com.thekeigroup.petboss.services.CommonService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author seth
 */
@Named(value = "productSearchController")
@SessionScoped
public class ProductSearchController implements Serializable{
    
    @Inject private CommonService commonService;
    private List<Product> productsList = new ArrayList<>();
    private Product selectedProduct;
    private String searchText;
    
    public void searchProduct(){
        Product productQP = new Product();
        productQP.setProductName(searchText);
        
        productsList = commonService.getProductsListByAttribute(productQP);
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    
    
}

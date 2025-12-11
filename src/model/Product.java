/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
/**
 *
 * @author deekshyarai
 */
public class Product {
    private String productName;
    private String brand;
    private String category;
    private int expiryYear;
    private int quantity;
    private List<String> suitability;
    
    public Product(String productName, String brand,String category, 
            int expiryYear, int quantity, List<String> suitability){
        this.productName= productName;
        this.brand= brand;
        this.category= category;
        this.expiryYear= expiryYear;
        this.quantity=quantity;
        this.suitability= suitability;
    }
    //getter method
    public String getProductName(){
        return productName;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public String getCategory(){
        return category;
    }
    
    public int getExpiryYear(){
        return expiryYear;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public List<String> getSuitability(){
        return suitability;
    }
    
    //setter method
    public void setProductName(String productName) { 
        this.productName = productName; 
    }
    public void setBrand(String brand) { 
        this.brand = brand; 
    }
    public void setCategory(String category) { 
        this.category = category; 
    }
    public void setExpiryYear(int expiryYear) { 
        this.expiryYear = expiryYear; 
    }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }
    public void setSuitability(List<String> suitability) { 
        this.suitability = suitability; 
    }
    
    @Override
    //converting object into meaningful readable sentence
    public String toString(){
        return productName + "-"+ brand;
    }
    
}

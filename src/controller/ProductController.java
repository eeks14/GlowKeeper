/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.Product;
import model.ProductInventory;
import java.util.List;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deekshyarai
 */
public class ProductController {
    private ProductInventory inventory;
    

    public ProductController(ProductInventory inventory) {
        this.inventory = inventory;
        
    }

    // CREATE
    /* =========================
       ADD PRODUCT
       ========================= */
    public void addProduct(Product product) {
        inventory.addProduct(product);
    }

    // READ
    public List<Product> getAllProducts() {
        return inventory.getAll();
    }

    // UPDATE
    public void updateProduct(int index, Product product) {
        inventory.updateProduct(index, product);
    }

    // DELETE
    public void deleteProduct(int index) {
        inventory.deleteProduct(index);
    }
    public void loadProductTable(JTable table) {
        String[] columns = {"Name", "Brand", "Category", "Expiry Year", "Quantity", "Suitability"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Product p : inventory.getAll()) {
            Object[] row = {
                p.getProductName(),
                p.getBrand(),
                p.getCategory(),
                p.getExpiryYear(),
                p.getQuantity(),
                p.getSuitability()
            };
            model.addRow(row);
        }

        table.setModel(model);
    }
    //bubble sort
    public void bubbleSortByName() {
        ArrayList<Product> list = inventory.getAll();
        int n = list.size();
        boolean swapped;

        for (int pass = 0; pass < n - 1; pass++) {
            swapped = false;

            for (int i = 0; i < n - pass - 1; i++) {
                if (list.get(i).getProductName()
                    .compareToIgnoreCase(
                    list.get(i + 1).getProductName()) > 0) {

                    Product temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public void bubbleSortByExpiry() {
        ArrayList<Product> list = inventory.getAll();
        int n = list.size();
        boolean swapped;

        for (int pass = 0; pass < n - 1; pass++) {
            swapped = false;

            for (int i = 0; i < n - pass - 1; i++) {
                if (list.get(i).getExpiryYear() >
                    list.get(i + 1).getExpiryYear()) {

                    Product temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public int binarySearchByName(String key) {
        bubbleSortByName(); 

        ArrayList<Product> list = inventory.getAll();
        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = list.get(mid)
                             .getProductName()
                             .compareToIgnoreCase(key);

            if (result == 0) return mid;
            else if (result < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public int binarySearchByExpiry(int year) {
        bubbleSortByExpiry(); 

        ArrayList<Product> list = inventory.getAll();
        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midYear = list.get(mid).getExpiryYear();

            if (midYear == year) return mid;
            else if (midYear < year) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public void sortProductsByExpiryYear(boolean ascending) {
        List<Product> products = inventory.getAll(); 

        int n = products.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean condition = ascending
                    ? products.get(j).getExpiryYear() > products.get(j + 1).getExpiryYear()
                    : products.get(j).getExpiryYear() < products.get(j + 1).getExpiryYear();

                if (condition) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Queue;
import model.Stack;
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
    Stack deletedStack = new Stack(5);
    Queue waitingQueue = new Queue(5);
    
    public ProductController(ProductInventory inventory) {
        this.inventory = inventory;
        
    }

    // CREATE
    /* =========================
       ADD PRODUCT
       ========================= */
    public void addProduct(Product product) {
        inventory.addProduct(product);
        waitingQueue.enQueue(product.getProductName());
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
    

    public String acceptProduct() {
        return waitingQueue.deQueue();
    }

    public String deleteProduct() {
        String deleted = waitingQueue.deQueue();
        if (deleted != null) {
            deletedStack.push(deleted);
        }
        return deleted;
    }

    public String undoDelete() {
        String restored = deletedStack.pop();
        if (restored != null) {
            waitingQueue.enQueue(restored);
        }
        return restored;
    }
    public Queue getWaitingQueue() {
        return waitingQueue;
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
   
    
    public void selectionSortByExpiry(ArrayList<Product> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getExpiryYear() < list.get(minIndex).getExpiryYear()) {
                    minIndex = j;
                }
            }

            Product temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }

    public void insertionSortByName(ArrayList<Product> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Product key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).getProductName()
                    .compareToIgnoreCase(key.getProductName()) > 0) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }
    }

   // Linear search by Product Name (partial match)
    public ArrayList<Product> linearSearchByName(ArrayList<Product> list, String key) {
        ArrayList<Product> result = new ArrayList<>();

        for (Product p : list) {
            if (p.getProductName().toLowerCase().contains(key.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    // Linear search by Brand (Author equivalent)
     public ArrayList<Product> linearSearchByBrand(ArrayList<Product> list, String key) {
        ArrayList<Product> result = new ArrayList<>();

        for (Product p : list) {
            if (p.getBrand().toLowerCase().contains(key.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
     
    public int binarySearchByExpiry(ArrayList<Product> list, int year) {
        
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midYear = list.get(mid).getExpiryYear();

            if (midYear == year) {
                return mid;
            } else if (midYear < year) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int binarySearchByName(ArrayList<Product> list, String key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            String midName = list.get(mid).getProductName();
            int result = midName.compareToIgnoreCase(key);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public void sortProductsByExpiryYear(boolean ascending) {
        List<Product> products = inventory.getAll();
        int n = products.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (ascending) {
                    if (products.get(j).getExpiryYear() >
                        products.get(j + 1).getExpiryYear()) {

                        Product temp = products.get(j);
                        products.set(j, products.get(j + 1));
                        products.set(j + 1, temp);
                    }
                } else {
                    if (products.get(j).getExpiryYear() <
                        products.get(j + 1).getExpiryYear()) {

                        Product temp = products.get(j);
                        products.set(j, products.get(j + 1));
                        products.set(j + 1, temp);
                    }
                }
            }
        }
    }
}

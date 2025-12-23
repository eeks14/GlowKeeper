/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Product;
import model.ProductInventory;
import java.util.List;
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
}

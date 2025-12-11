package model;

import java.time.Year;
import java.util.*;

public class ProductInventory {
    private List<Product> products = new ArrayList<>();

    // Check if product name exists (simple exact match)
    private boolean existsByName(String name) {
        for (Product p : products) {
            if (p.getProductName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // CREATE
    public void addProduct(Product p) {
        if (p.getProductName().isEmpty()) {
            throw new RuntimeException("Product name is required");
        }
        if (existsByName(p.getProductName())) {
            throw new RuntimeException("Product name already exists");
        }
        int currentYear = Year.now().getValue();
        if (p.getExpiryYear() < currentYear || p.getExpiryYear() > currentYear + 5) {
            throw new RuntimeException("Invalid expiry year");
        }
        if (p.getQuantity() < 0) {
            throw new RuntimeException("Quantity cannot be negative");
        }

        products.add(p);
    }

    // READ
    public List<Product> getAll() {
        return products;
    }

    // UPDATE
    public void updateProduct(int index, Product updated) {
        if (updated.getProductName().isEmpty()) {
            throw new RuntimeException("Product name is required");
        }
        for (int i = 0; i < products.size(); i++) {
            if (i != index && products.get(i).getProductName().equals(updated.getProductName())) {
                throw new RuntimeException("Another product with this name already exists");
            }
        }
        int currentYear = Year.now().getValue();
        if (updated.getExpiryYear() < currentYear || updated.getExpiryYear() > currentYear + 5) {
            throw new RuntimeException("Invalid expiry year");
        }
        if (updated.getQuantity() < 0) {
            throw new RuntimeException("Quantity cannot be negative");
        }

        products.set(index, updated);
    }

    // DELETE
    public void deleteProduct(int index) {
        products.remove(index);
    }
}

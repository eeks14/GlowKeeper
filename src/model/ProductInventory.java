package model;

import java.time.Year;
import java.util.ArrayList;

public class ProductInventory {

    private ArrayList<Product> products;

    public ProductInventory() {
        products = new ArrayList<>();
    }

    // ADD PRODUCT
    public void addProduct(Product product) {
        if (product.getProductName().trim().isEmpty()) {
            throw new RuntimeException("Product name cannot be empty");
        }

        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(product.getProductName())) {
                throw new RuntimeException("Product already exists");
            }
        }

        int currentYear = Year.now().getValue();
        if (product.getExpiryYear() < currentYear ||
            product.getExpiryYear() > currentYear + 5) {
            throw new RuntimeException("Expiry year must be within next 5 years");
        }

        if (product.getQuantity() < 0) {
            throw new RuntimeException("Quantity cannot be negative");
        }

        products.add(product);
    }

    // READ
    public ArrayList<Product> getAll() {
        return products;
    }

    // UPDATE
    public void updateProduct(int index, Product product) {
        products.set(index, product);
    }

    // DELETE
    public void deleteProduct(int index) {
        products.remove(index);
    }
}

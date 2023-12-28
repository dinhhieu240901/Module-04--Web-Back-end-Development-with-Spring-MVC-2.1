package com.example.productmanagment.service.impl;

import com.example.productmanagment.bean.Product;
import com.example.productmanagment.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 13", 1099, "For the tech-savvy", "Apple"));
        products.put(2, new Product(2, "iPhone 13 Pro", 1499, "For the professionals", "Apple"));
        products.put(3, new Product(3, "Galaxy S21", 999, "For the Android lovers", "Samsung"));
        products.put(4, new Product(4, "Note 20", 1299, "For the note-takers", "Samsung"));
        products.put(5, new Product(5, "HTC U12+", 799, "For the music lovers", "HTC"));
        products.put(6, new Product(6, "Xperia 5 III", 999, "For the photographers", "Sony"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}

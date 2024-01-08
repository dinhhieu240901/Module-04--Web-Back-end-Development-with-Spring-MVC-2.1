package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }


    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }
    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public void removeProduct(Product product){
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        if (itemEntry.getValue() == 1) {
            products.remove(product);
        } else {
            Integer newQuantity = itemEntry.getValue() - 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }
    public void updateProductQuantity(Product product,Integer quantity){
        if (quantity > 0) {
            if (checkItemInCart(product)) {
                Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
                products.replace(itemEntry.getKey(), quantity);
            } else {
                addProduct(product);
            }
        } else {
            removeProduct(product);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product,Integer> entry:products.entrySet()
             ) {
            productQuantity+=entry.getValue();
        }
        return productQuantity;
    }
    public Integer countItemQuantity(){
        return products.size();
    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product,Integer> entry:products.entrySet()
             ) {
            payment+=entry.getKey().getPrice() *(float) entry.getValue();
        }
        return payment;
    }
    public Integer getProductQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }
    public void deleteProduct(Product product){
        if (checkItemInCart(product)){
            Map.Entry<Product,Integer> entry = selectItemInCart(product);
            products.remove(entry.getKey());
        }
    }
}

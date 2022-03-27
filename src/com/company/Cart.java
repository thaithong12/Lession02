package com.company;

import java.util.HashSet;
import java.util.Set;

public class Cart {
    private Set<Product> products;

    // Tong tien gio hang
    private Double totalPrice;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart(Set<Product> products, Double totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public Cart() {
        products = new HashSet<>();
        totalPrice = 0.0;
    }

    @Override
    public String toString() {
        final String[] temp = {""};
        products.stream().forEach(i -> temp[0] = (temp[0] + i.toString() + "\n"));
        return "Card{" +
                "products= \n" + temp[0] +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

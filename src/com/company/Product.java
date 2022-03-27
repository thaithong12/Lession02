package com.company;

public class Product {

    // MA SAN PHAM
    private Integer productId;

    // GIA TIEN
    private Double price;

    // SO LUONG SAN PHAM
    private Integer quantity;

    public Product() {
    }

    public Product(Integer productId, Double price, Integer quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

}

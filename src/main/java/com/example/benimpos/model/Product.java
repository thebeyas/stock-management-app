package com.example.benimpos.model;

import jakarta.persistence.*;

@Entity // Hibernate'e bu sınıfın bir varlık (entity) olduğunu söyler
@Table(name = "urunler") // Veritabanındaki tablo adını belirler
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan bir ID alanı
    private int id;

    private String productName;
    private int stockQuantity;
    private double price;

    // Yapıcılar
    public Product() {
    }

    public Product(int id, String productName, int stockQuantity, double price) {
        this.id = id;
        this.productName = productName;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    // Getter ve Setter'lar
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

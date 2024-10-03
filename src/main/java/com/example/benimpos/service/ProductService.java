package com.example.benimpos.service;

import com.example.benimpos.model.Product;
import com.example.benimpos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // ProductRepository, Spring tarafından otomatik olarak enjekte ediliyor
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Ürün ekleme işlemi
    public void addProduct(Product product) {
        productRepository.save(product); // Veritabanına ürün ekleniyor
        System.out.println("Ürün eklendi: " + product.getProductName());
    }

    // Tüm ürünleri listeleme işlemi
    public List<Product> getProducts() {
        return productRepository.findAll(); // Veritabanındaki tüm ürünler döndürülüyor
    }

    // Ürün güncelleme işlemi
    public void updateProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            productRepository.save(product); // Ürün mevcutsa güncelleniyor
            System.out.println("Ürün güncellendi: " + product.getProductName());
        } else {
            System.out.println("Güncellenecek ürün bulunamadı.");
        }
    }

    // Ürün silme işlemi
    public void deleteProduct(int productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId); // Ürün mevcutsa siliniyor
            System.out.println("Ürün silindi: ID " + productId);
        } else {
            System.out.println("Silinecek ürün bulunamadı.");
        }
    }
}

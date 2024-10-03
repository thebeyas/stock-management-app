package com.example.benimpos.controller;

import com.example.benimpos.model.Product;
import com.example.benimpos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "product"; // product.html dosyasının ismi
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/api/products"; // Listeyi tekrar göstermek için yönlendir
    }

    @PostMapping("/{id}") // Güncelleme işlemi için
    public String updateProduct(@PathVariable int id, @ModelAttribute Product product) {
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/api/products"; // Güncellemeden sonra listeyi göster
    }

    @PostMapping("/{id}/delete") // Silme işlemi için
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/api/products"; // Silmeden sonra listeyi göster
    }
}

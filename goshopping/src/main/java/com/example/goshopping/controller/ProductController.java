package com.example.goshopping.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.goshopping.domain.Product;
import com.example.goshopping.domain.ProductRepository;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin/addProduct";
    }

    @PostMapping("/add")
    public String addProductSubmit(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename();
            String uploadDir = "uploads/";

            try {
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path filePath = uploadPath.resolve(fileName);
                imageFile.transferTo(filePath);
                product.setPImage("/" + uploadDir + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "admin/editProduct";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, @ModelAttribute Product product, @RequestParam("imageFile") MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename();
            String uploadDir = "uploads/";

            try {
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path filePath = uploadPath.resolve(fileName);
                imageFile.transferTo(filePath);
                product.setPImage("/" + uploadDir + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        productRepository.save(product);
        return "redirect:/mypage";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/mypage";
    }

    @GetMapping("/detail/{id}")
    public String showProductDetail(@PathVariable("id") Long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "admin/productDetail";
    }
    
    
    @GetMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "admin/productList";
    }
}


package com.anj.ecommerce_app.service;

import com.anj.ecommerce_app.model.Product;
import com.anj.ecommerce_app.repo.ProductRepo;
import exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        Optional<Product> optionalProduct = repo.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setReleaseDate(product.getReleaseDate());
            existingProduct.setAvailable(product.isAvailable());
            existingProduct.setQuantity(product.getQuantity());

            existingProduct.setImageData(imageFile.getBytes());
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setImageType(imageFile.getContentType());

            return repo.save(existingProduct);
        } else {
            return null;
        }
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword){
        return repo.searchProducts(keyword);
    }
}

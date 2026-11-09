package org.gallegos.java_rest_api_lab.service.impl;

import lombok.RequiredArgsConstructor;
import org.gallegos.java_rest_api_lab.exception.ResourceNotFoundException;
import org.gallegos.java_rest_api_lab.model.Product;
import org.gallegos.java_rest_api_lab.repository.IProductRepository;
import org.gallegos.java_rest_api_lab.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product not found with id " + id));
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Product existingProduct = findById(id);

        if (product.getName() != null) {existingProduct.setName(product.getName());}
        if (product.getDescription() != null) {existingProduct.setDescription(product.getDescription());}
        if (product.getPrice() != null) {existingProduct.setPrice(product.getPrice());}
        if (product.getStock() != null) {existingProduct.setStock(product.getStock());}

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = findById(id);
        productRepository.delete(existingProduct);
    }
}
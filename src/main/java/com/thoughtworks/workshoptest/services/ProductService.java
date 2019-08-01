package com.thoughtworks.workshoptest.services;

import com.thoughtworks.workshoptest.models.Product;
import com.thoughtworks.workshoptest.repositories.ProductRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getAll() {
    return productRepository.findAll();
  }
}

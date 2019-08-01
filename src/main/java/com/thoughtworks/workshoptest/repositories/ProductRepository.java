package com.thoughtworks.workshoptest.repositories;

import com.thoughtworks.workshoptest.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}

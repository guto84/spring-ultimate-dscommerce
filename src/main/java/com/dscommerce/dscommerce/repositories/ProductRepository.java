package com.dscommerce.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dscommerce.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

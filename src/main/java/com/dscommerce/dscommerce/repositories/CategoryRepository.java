package com.dscommerce.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dscommerce.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}

package com.dscommerce.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dscommerce.dscommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}

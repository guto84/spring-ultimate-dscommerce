package com.dscommerce.dscommerce.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dscommerce.dscommerce.dto.OrderDTO;
import com.dscommerce.dscommerce.dto.OrderItemDTO;
import com.dscommerce.dscommerce.entities.Order;
import com.dscommerce.dscommerce.entities.OrderItem;
import com.dscommerce.dscommerce.entities.OrderStatus;
import com.dscommerce.dscommerce.entities.Product;
import com.dscommerce.dscommerce.entities.User;
import com.dscommerce.dscommerce.repositories.OrderItemRepository;
import com.dscommerce.dscommerce.repositories.OrderRepository;
import com.dscommerce.dscommerce.repositories.ProductRepository;
import com.dscommerce.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Optional<Order> result = repository.findById(id);
        Order order = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        authService.validateSelfOrAdmin(order.getUser().getId());
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setUser(user);

        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}

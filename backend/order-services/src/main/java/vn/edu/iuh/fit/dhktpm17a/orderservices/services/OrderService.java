package vn.edu.iuh.fit.dhktpm17a.orderservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import vn.edu.iuh.fit.dhktpm17a.orderservices.dto.OrderDTO;
import vn.edu.iuh.fit.dhktpm17a.orderservices.entities.Order;
import vn.edu.iuh.fit.dhktpm17a.orderservices.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerId(orderDTO.getCustomerId());
        order.setProductIds(orderDTO.getProductIds());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);
        return new OrderDTO(savedOrder.getId(), savedOrder.getCustomerId(),
                savedOrder.getProductIds(), savedOrder.getTotalPrice(),
                savedOrder.getStatus(), savedOrder.getCreatedAt());
    }

    public OrderDTO getOrder(String id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return new OrderDTO(order.getId(), order.getCustomerId(),
                order.getProductIds(), order.getTotalPrice(),
                order.getStatus(), order.getCreatedAt());
    }

    public void cancelOrder(String id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        order.setStatus("CANCELLED");
        orderRepository.save(order);
    }
    public List<OrderDTO> getAllOrders() {
    List<Order> orders = orderRepository.findAll();
    return orders.stream()
        .map(order -> new OrderDTO(
            order.getId(), 
            order.getCustomerId(),
            order.getProductIds(), 
            order.getTotalPrice(),
            order.getStatus(), 
            order.getCreatedAt()))
        .collect(Collectors.toList());
}
}
package com.ewa.project.service;

import com.ewa.project.model.OrderDto;


import java.util.List;

public interface OrderService {

    OrderDto getOrderById(Long orderId); // Change the parameter name to orderId

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(Long orderId, OrderDto orderDto); // Change the parameter name to orderId

    String deleteOrder(Long orderId); // Change the parameter name to orderId

    List<OrderDto> getAllOrders();
    
}

package com.ewa.project.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.ewa.project.entity.Order;
import com.ewa.project.model.OrderDto;

@Component // Indicates that this class is a Spring component
public class OrderConverter {

    // Convert from dto to Entity
    public Order convertToOrderEntity(OrderDto orderDto) {
        Order order = new Order();
        if (orderDto != null) {
            BeanUtils.copyProperties(orderDto, order);
        }
        return order;
    }

    // Convert from Entity to dto
    public OrderDto convertToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        if (order != null) {
            BeanUtils.copyProperties(order, orderDto);
        }
        return orderDto;
    }
}

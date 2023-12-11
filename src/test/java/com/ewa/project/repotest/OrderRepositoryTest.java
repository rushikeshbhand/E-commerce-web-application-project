package com.ewa.project.repotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ewa.project.dao.OrderRepository;
import com.ewa.project.entity.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testCreateOrder() {
        // Create and save an order
        Order order = new Order();
        order.setOrderStatus("Pending");
        order.setOrderQuantity(2);
        order.setOrderTotalPrice(150.0);

        Order savedOrder = orderRepository.save(order);
        assertNotNull(savedOrder.getOrderId());
    }

    @Test
    public void testGetAllOrders() {
        // Clear the database to ensure a clean state
        orderRepository.deleteAll();

        // Create and save multiple order entities
        Order order1 = new Order(null, "Shipped", 3, 250.0, null, null, null);
        Order order2 = new Order(null, "Processing", 1, 100.0, null, null, null);
        Order order3 = new Order(null, "Delivered", 5, 400.0, null, null, null);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        // Retrieve all orders from the database
        List<Order> allOrders = orderRepository.findAll();

        // Assert that the list is not empty and contains the expected number of orders
        assertNotNull(allOrders);
        assertEquals(3, allOrders.size());
    }

    @Test
    public void testGetOrderById() {
        // Create and save an order
        Order order = new Order(null, "Processing", 2, 150.0, null, null, null);
        order = orderRepository.save(order);

        // Retrieve the order by ID
        Order retrievedOrder = orderRepository.findById(order.getOrderId()).orElse(null);

        // Assert that the retrieved order is not null and has the correct ID
        assertNotNull(retrievedOrder);
        assertEquals(order.getOrderId(), retrievedOrder.getOrderId());
        assertEquals("Processing", retrievedOrder.getOrderStatus());
        assertEquals(2, retrievedOrder.getOrderQuantity());
        assertEquals(150.0, retrievedOrder.getOrderTotalPrice());
    }

    @Test
    public void testUpdateOrderById() {
        // Create and save an order
        Order order = new Order(null, "Pending", 3, 200.0, null, null, null);
        order = orderRepository.save(order);

        // Update the order's details
        Long orderId = order.getOrderId();
        Order updatedOrder = orderRepository.findById(orderId).orElse(null);
        assertNotNull(updatedOrder);

        // Modify the order's attributes
        updatedOrder.setOrderStatus("Shipped"); // Update order status
        updatedOrder.setOrderQuantity(4); // Update order quantity
        updatedOrder.setOrderTotalPrice(300.0); // Update order total price

        // Save the updated order
        updatedOrder = orderRepository.save(updatedOrder);

        // Retrieve the updated order from the database
        Order retrievedOrder = orderRepository.findById(orderId).orElse(null);
        assertNotNull(retrievedOrder);

        // Assert that the attributes have been updated
        assertEquals("Shipped", retrievedOrder.getOrderStatus());
        assertEquals(4, retrievedOrder.getOrderQuantity());
        assertEquals(300.0, retrievedOrder.getOrderTotalPrice());
    }

    @Test
    public void testDeleteOrderById() {
        // Create and save an order
        Order order = new Order(null, "Delivered", 1, 80.0, null, null, null);
        order = orderRepository.save(order);

        // Get the ID of the order to be deleted
        Long orderId = order.getOrderId();

        // Delete the order by ID
        orderRepository.deleteById(orderId);

        // Try to retrieve the deleted order by ID, and it should be null
        Order deletedOrder = orderRepository.findById(orderId).orElse(null);
        assertNull(deletedOrder);
    }
}


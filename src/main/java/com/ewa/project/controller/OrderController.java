package com.ewa.project.controller;

import com.ewa.project.model.OrderDto;
import com.ewa.project.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController // The @RestController annotation indicates that this class is a spring MVC
				// controller responsible for handling HTTP requests and returning data as
				// response
@RequestMapping("/api/orders") // The @RequestMapping annotation sets the starting address ("/api/orders") for
								// all the operations this controller handle and any operations in this class
@CrossOrigin("http://localhost:4200")				// will be based on this address
public class OrderController {

	@Autowired // automatically inject object of order service
	private OrderService orderService;

	// handling create order request
	@PostMapping("/createOrder")
	public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
		OrderDto createdOrder = orderService.createOrder(orderDto);
		return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	}

	// handling select all order request
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrderDto>> getAllOrders() {
		List<OrderDto> orders = orderService.getAllOrders();
		return ResponseEntity.ok(orders);
	}

	// handling select order request
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
		OrderDto order = orderService.getOrderById(orderId);
		return ResponseEntity.ok(order);
	}

	// handling order update request
	@PutMapping("/{orderId}")
	public ResponseEntity<OrderDto> updateOrder(@Valid @PathVariable Long orderId, @RequestBody OrderDto orderDto) {
		OrderDto updatedOrder = orderService.updateOrder(orderId, orderDto);
		return ResponseEntity.ok(updatedOrder);
	}

	// handling delete order request
	@DeleteMapping("/{orderId}")
	public String deleteOrder(@PathVariable Long orderId) {
		return orderService.deleteOrder(orderId);
	}

}

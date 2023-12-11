package com.ewa.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ewa.project.model.CartDto;
import com.ewa.project.service.CartService;


@RestController // The @RestController annotation indicates that this class is a spring MVC
				// controller responsible for handling HTTP requests and returning data as
				// response
@RequestMapping("/api/carts") // The @RequestMapping annotation sets the starting address ("/api/carts") for
@CrossOrigin("http://localhost:4200")						// will be based on this address
public class CartController {

	@Autowired // Automatically inject an object of CartService
	private CartService cartService;

	// handling creating cart request
	@PostMapping("/createCart")
	public ResponseEntity<CartDto> createCart(@RequestBody CartDto cartDto) {
		CartDto createdCart = cartService.createCart(cartDto);
		return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
	}

	// handling selecting all carts request
	@GetMapping("/getAllCarts")
	public List<CartDto> getAllCarts() {
		return cartService.getAllCarts();
	}

	// handling selecting cart by its id request
	@GetMapping("/{cartId}")
	public CartDto getCartById(@PathVariable Long cartId) {
		return cartService.getCartById(cartId);
	}

	// handling updating cart request
	@PutMapping("/{cartId}")
	public CartDto updateCart(@PathVariable Long cartId, @RequestBody CartDto cartDto) {
		return cartService.updateCart(cartId, cartDto);
	}

	// handling delete cart request
	@DeleteMapping("/{cartId}")
	public String deleteCart(@PathVariable Long cartId) {
		return cartService.deleteCart(cartId);
	}
}

package com.ewa.project.serviceimpl;

import com.ewa.project.service.CartService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewa.project.converter.CartConverter;
import com.ewa.project.dao.CartRepository;
import com.ewa.project.entity.Cart;
import com.ewa.project.model.CartDto;

@Service
public class CartServiceImpl implements CartService {

	@Autowired //Autowired is used to inject object automatically
	private CartRepository cartRepository;

	@Autowired
	private CartConverter cartConverter;

	@Override //creating cart and returning cartdto
	public CartDto createCart(CartDto cartDto) {
		Cart cart = cartConverter.dtoToEntity(cartDto);
		cart = cartRepository.save(cart);
		return cartConverter.entityToDto(cart);
	}

	@Override //getting all carts
	public List<CartDto> getAllCarts() {
		List<Cart> carts = cartRepository.findAll();
		List<CartDto> cartDtos = new ArrayList<>();

		for (Cart cart : carts) { 
			cartDtos.add(cartConverter.entityToDto(cart));
		}

		return cartDtos;
	}

	@Override //selecting carting by cart id
	public CartDto getCartById(Long cartId) {
	    Cart cart = cartRepository.findCartByCartId(cartId);
	    if (cart == null) {
	        throw new RuntimeException("Cart not found with ID: " + cartId);
	    }
	    return cartConverter.entityToDto(cart);    
	}

	@Override //updating cart by cartid and if cart with specified id is not found then cart not found with id will prit
	public CartDto updateCart(Long cartId, CartDto cartDto) {
		Cart existingCart = cartRepository.findCartByCartId(cartId);
		if (existingCart == null) {
			throw new RuntimeException("Cart not found with ID: " + cartId);
		}
		Cart updatedCart = cartConverter.dtoToEntity(cartDto);
		updatedCart.setCartId(existingCart.getCartId());
		cartRepository.save(updatedCart);
		return cartConverter.entityToDto(updatedCart);
	}

	@Override
	public String deleteCart(Long cartId) { //deleting cart and if cart is deleted successfully then cart has been deleted will print as output
		Cart cart = cartRepository.findCartByCartId(cartId);
		if (cart == null) {
			throw new RuntimeException("Cart not found with ID: " + cartId);
		}
		cartRepository.delete(cart);
		return "Cart with ID " + cartId + " has been deleted successfully.";
	}
}

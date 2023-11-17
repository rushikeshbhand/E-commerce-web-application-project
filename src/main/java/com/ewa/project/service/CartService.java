package com.ewa.project.service;

import java.util.List;
import com.ewa.project.model.CartDto;

public interface CartService {
    CartDto createCart(CartDto cartDto);
    
    List<CartDto> getAllCarts();
    
    CartDto getCartById(Long cartId);
    
    CartDto updateCart(Long cartId, CartDto cartDto);
    
    String deleteCart(Long cartId);
}

package com.ewa.project.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ewa.project.entity.Cart;
import com.ewa.project.model.CartDto;

@Component // Indicates that this class is a Spring component
public class CartConverter {

    // Convert from Entity to dto
    public CartDto entityToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        if (cart != null) {
            BeanUtils.copyProperties(cart, cartDto);
         
        }
        return cartDto;
    }

    // Convert from dto to Entity
    public Cart dtoToEntity(CartDto cartDto) {
        Cart cart = new Cart();
        if (cartDto != null) {
            BeanUtils.copyProperties(cartDto, cart);
        
        }
        return cart;
    }
}

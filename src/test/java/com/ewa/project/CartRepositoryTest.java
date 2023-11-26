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

import com.ewa.project.dao.CartRepository;
import com.ewa.project.entity.Cart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testCreateCart() {
        // Create and save a cart
        Cart cart = new Cart();
        cart.setQuantity(2);
        cart.setTotalPrice(50.0);

        Cart savedCart = cartRepository.save(cart);
        assertNotNull(savedCart.getCartId());
    }

    @Test
    public void testGetAllCarts() {
        // Clear the database to ensure a clean state
        cartRepository.deleteAll();

        // Create and save multiple cart entities
        Cart cart1 = new Cart(null, 3, 75.0, null, null, null);
        Cart cart2 = new Cart(null, 1, 25.0, null, null, null);
        Cart cart3 = new Cart(null, 2, 50.0, null, null, null);

        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        // Retrieve all carts from the database
        List<Cart> allCarts = cartRepository.findAll();

        // Assert that the list is not empty and contains the expected number of carts
        assertNotNull(allCarts);
        assertEquals(3, allCarts.size());
    }

    @Test
    public void testGetCartById() {
        // Create and save a cart
        Cart cart = new Cart(null, 4, 100.0, null, null, null);
        cart = cartRepository.save(cart);

        // Retrieve the cart by ID
        Cart retrievedCart = cartRepository.findById(cart.getCartId()).orElse(null);

        // Assert that the retrieved cart is not null and has the correct ID
        assertNotNull(retrievedCart);
        assertEquals(cart.getCartId(), retrievedCart.getCartId());
        assertEquals(4, retrievedCart.getQuantity());
        assertEquals(100.0, retrievedCart.getTotalPrice());
    }

    @Test
    public void testUpdateCartById() {
        // Create and save a cart
        Cart cart = new Cart(null, 2, 50.0, null, null, null);
        cart = cartRepository.save(cart);

        // Update the cart's details
        Long cartId = cart.getCartId();
        Cart updatedCart = cartRepository.findById(cartId).orElse(null);
        assertNotNull(updatedCart);

        // Modify the cart's attributes
        updatedCart.setQuantity(3); // Update quantity
        updatedCart.setTotalPrice(75.0); // Update total price

        // Save the updated cart
        updatedCart = cartRepository.save(updatedCart);

        // Retrieve the updated cart from the database
        Cart retrievedCart = cartRepository.findById(cartId).orElse(null);
        assertNotNull(retrievedCart);

        // Assert that the attributes have been updated
        assertEquals(3, retrievedCart.getQuantity());
        assertEquals(75.0, retrievedCart.getTotalPrice());
    }

    @Test
    public void testDeleteCartById() {
        // Create and save a cart
        Cart cart = new Cart(null, 1, 25.0, null, null, null);
        cart = cartRepository.save(cart);

        // Get the ID of the cart to be deleted
        Long cartId = cart.getCartId();

        // Delete the cart by ID
        cartRepository.deleteById(cartId);

        // Try to retrieve the deleted cart by ID, and it should be null
        Cart deletedCart = cartRepository.findById(cartId).orElse(null);
        assertNull(deletedCart);
    }
}


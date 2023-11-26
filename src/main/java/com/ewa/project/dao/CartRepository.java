package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Cart;
@Repository // Indicates that this interface is a Spring Data repository
public interface CartRepository extends JpaRepository<Cart, Long> {// It provides methods for common CRUD operations

	Cart findCartByCartId(Long cartId);

}

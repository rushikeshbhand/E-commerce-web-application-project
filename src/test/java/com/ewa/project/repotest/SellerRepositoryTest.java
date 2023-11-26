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

import com.ewa.project.dao.SellerRepository;
import com.ewa.project.entity.Seller;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerRepositoryTest {

    @Autowired
    private SellerRepository sellerRepository;

    @Test
    public void testCreateSeller() {
        // Create and save a seller
        Seller seller = createSampleSeller();

        Seller savedSeller = sellerRepository.save(seller);
        assertNotNull(savedSeller.getSellerId());
    }

    @Test
    public void testGetAllSellers() {
        // Clear the database to ensure a clean state
        sellerRepository.deleteAll();

        // Create and save multiple seller entities
        Seller seller1 = createSampleSeller("seller1", "password1", "seller1@example.com", "1234567890", "Address 1");
        Seller seller2 = createSampleSeller("seller2", "password2", "seller2@example.com", "9876543210", "Address 2");

        sellerRepository.saveAll(List.of(seller1, seller2));

        // Retrieve all sellers from the database
        List<Seller> allSellers = sellerRepository.findAll();

        // Assert that the list is not empty and contains the expected number of sellers
        assertNotNull(allSellers);
        assertEquals(2, allSellers.size());
    }

    @Test
    public void testGetSellerById() {
        // Create and save a seller
        Seller seller = createSampleSeller();
        seller = sellerRepository.save(seller);

        // Retrieve the seller by ID
        Seller retrievedSeller = sellerRepository.findById(seller.getSellerId()).orElse(null);

        // Assert that the retrieved seller is not null and has the correct ID
        assertNotNull(retrievedSeller);
        assertEquals(seller.getSellerId(), retrievedSeller.getSellerId());
        assertSellerEquals(seller, retrievedSeller);
    }

    @Test
    public void testUpdateSellerById() {
        // Create and save a seller
        Seller seller = createSampleSeller();
        seller = sellerRepository.save(seller);

        // Update the seller's details
        Long sellerId = seller.getSellerId();
        Seller updatedSeller = sellerRepository.findById(sellerId).orElse(null);
        assertNotNull(updatedSeller);

        // Modify the seller's attributes
        updatedSeller.setSellerPassword("newPassword"); // Update seller password
        updatedSeller.setSellerEmail("newemail@example.com"); // Update seller email

        // Save the updated seller
        updatedSeller = sellerRepository.save(updatedSeller);

        // Retrieve the updated seller from the database
        Seller retrievedSeller = sellerRepository.findById(sellerId).orElse(null);
        assertNotNull(retrievedSeller);

        // Assert that the attributes have been updated
        assertEquals("newPassword", retrievedSeller.getSellerPassword());
        assertEquals("newemail@example.com", retrievedSeller.getSellerEmail());
    }

    @Test
    public void testDeleteSellerById() {
        // Create and save a seller
        Seller seller = createSampleSeller();
        seller = sellerRepository.save(seller);

        // Get the ID of the seller to be deleted
        Long sellerId = seller.getSellerId();

        // Delete the seller by ID
        sellerRepository.deleteById(sellerId);

        // Try to retrieve the deleted seller by ID, and it should be null
        Seller deletedSeller = sellerRepository.findById(sellerId).orElse(null);
        assertNull(deletedSeller);
    }

    // Helper methods for creating sample sellers

    private Seller createSampleSeller() {
        return createSampleSeller("sampleSeller", "samplePassword", "sample@example.com", "1234567890", "Sample Address");
    }

    private Seller createSampleSeller(String username, String password, String email, String contact, String address) {
        Seller seller = new Seller();
        seller.setSellerUsername(username);
        seller.setSellerPassword(password);
        seller.setSellerEmail(email);
        seller.setSellerContact(contact);
        seller.setSellerAddress(address);
        return seller;
    }

    private void assertSellerEquals(Seller expected, Seller actual) {
        assertEquals(expected.getSellerUsername(), actual.getSellerUsername());
        assertEquals(expected.getSellerPassword(), actual.getSellerPassword());
        assertEquals(expected.getSellerEmail(), actual.getSellerEmail());
        assertEquals(expected.getSellerContact(), actual.getSellerContact());
        assertEquals(expected.getSellerAddress(), actual.getSellerAddress());
    }
}


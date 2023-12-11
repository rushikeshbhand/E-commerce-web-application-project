package com.ewa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewa.project.config.AuthResponse;
import com.ewa.project.config.JwtUtil;
import com.ewa.project.exception.SellerNotFoundException;
import com.ewa.project.model.SellerDto;
import com.ewa.project.service.SellerService;

@RestController // The @RestController annotation indicates that this class is a spring MVC
				// controller responsible for handling HTTP requests and returning data as
				// response
@RequestMapping("/sellers") // The @RequestMapping annotation sets the starting address ("/sellers") for all
							// the operations this controller handle and any operations in this class will
@CrossOrigin("http://localhost:4200")							// be based on this address
public class SellerController {

	@Autowired // automatically inject object of seller service
	private SellerService sellerService;

	// handling create seller request
	@PostMapping("/signup")
	public ResponseEntity<SellerDto> createSeller(@RequestBody SellerDto sellerDto) {
		SellerDto createdSeller = sellerService.createSeller(sellerDto);
		return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> loginSeller(@RequestBody SellerDto sellerDto) {
	    String email = sellerDto.getSellerEmail();
	    String password = sellerDto.getSellerPassword();

	    SellerDto authenticatedSeller = sellerService.authenticateSeller(email, password);
	    String token = JwtUtil.generateToken(authenticatedSeller.getSellerEmail());

	    AuthResponse authResponse = new AuthResponse();
	    authResponse.setToken(token);

	    return ResponseEntity.ok(authResponse);
	}
	
	// handling select all seller request
	@GetMapping("/getAllSellers")
	public ResponseEntity<List<SellerDto>> getAllSellers() {
		List<SellerDto> sellers = sellerService.getAllSellers();
		return new ResponseEntity<>(sellers, HttpStatus.OK);
	}

	// handling select seller request
	@GetMapping("/{sellerId}")
	public ResponseEntity<SellerDto> getSellerById(@PathVariable Long sellerId) {
		SellerDto sellerDto = sellerService.getSellerById(sellerId);
		if (sellerDto == null) {
			throw new SellerNotFoundException("Seller not found with ID: " + sellerId);
		}
		return new ResponseEntity<>(sellerDto, HttpStatus.OK);
	}

	// handling update seller request
	@PutMapping("/{sellerId}")
	public ResponseEntity<SellerDto> updateSeller(@PathVariable Long sellerId, @RequestBody SellerDto sellerDto) {
		SellerDto updatedSeller = sellerService.updateSeller(sellerId, sellerDto);
		return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
	}

	// handling delete seller request
//	@DeleteMapping("/{sellerId}")
//	public String deleteSeller(@PathVariable Long sellerId) {
//		return sellerService.deleteSeller(sellerId);
//	}
	
	 @DeleteMapping("/{email}")
	    public ResponseEntity<String> deleteSellerByEmail(@PathVariable String email) {
	        try {
	            String response = sellerService.deleteSellerByEmail(email);
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } catch (SellerNotFoundException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}

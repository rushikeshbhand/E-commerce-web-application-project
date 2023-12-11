package com.ewa.project.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewa.project.converter.SellerConverter;
import com.ewa.project.dao.SellerRepository;
import com.ewa.project.entity.Seller;
import com.ewa.project.exception.SellerNotFoundException;
import com.ewa.project.model.SellerDto;
import com.ewa.project.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired //Autowired is used to inject object automatically
    private SellerRepository sellerRepository;

    @Autowired
    private SellerConverter sellerConverter;

    @Override //creating the seller and returning the seller dto
    public SellerDto createSeller(SellerDto sellerDto) {
        Seller seller = sellerConverter.convertToSellerEntity(sellerDto);
        seller = sellerRepository.save(seller);
        return sellerConverter.convertToSellerDto(seller);
    }
    
    @Override
    public SellerDto authenticateSeller(String email, String password) {
        Seller seller = sellerRepository.findBySellerEmailAndSellerPassword(email, password);

        if (seller == null) {
            throw new SellerNotFoundException("Invalid email or password");
        }

        return sellerConverter.convertToSellerDto(seller);
    }
 
    @Override //selecting the seller its id 
    public SellerDto getSellerById(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElse(null);
        return sellerConverter.convertToSellerDto(seller);
    }

    @Override //updating the seller 
    public SellerDto updateSeller(Long sellerId, SellerDto sellerDto) {
        Seller seller = sellerConverter.convertToSellerEntity(sellerDto);
        seller.setSellerId(sellerId);
        seller = sellerRepository.save(seller);
        return sellerConverter.convertToSellerDto(seller);
    }

    @Override //deleting the seller
    public String deleteSeller(Long sellerId) {
        sellerRepository.deleteById(sellerId);
        return "Seller with ID " + sellerId + " has been deleted successfully.";
    }

    @Override //selecting all sellers
    public List<SellerDto> getAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        List<SellerDto> sellerDtos = new ArrayList<>();

        for (Seller seller : sellers) {
            sellerDtos.add(sellerConverter.convertToSellerDto(seller));
        }

        return sellerDtos;
    }
    
    @Override
    public String deleteSellerByEmail(String email) {
        Seller seller = sellerRepository.findBySellerEmail(email);
        if (seller == null) {
            throw new SellerNotFoundException("Seller not found with email: " + email);
        }
        sellerRepository.delete(seller);
        return "Seller with email " + email + " has been deleted successfully.";
    }
}

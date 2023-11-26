package com.ewa.project.service;

import java.util.List;

import com.ewa.project.model.SellerDto;

public interface SellerService {
    SellerDto createSeller(SellerDto sellerDto);
    
    SellerDto getSellerById(Long sellerId);
    
    List<SellerDto> getAllSellers();
    
    SellerDto updateSeller(Long sellerId, SellerDto sellerDto);
    
    String deleteSeller(Long sellerId);
}

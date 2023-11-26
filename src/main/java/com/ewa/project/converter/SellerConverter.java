package com.ewa.project.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ewa.project.entity.Seller;
import com.ewa.project.model.SellerDto;

@Component // Indicates that this class is a Spring component
public class SellerConverter {

    // convert from seller dto to seller entity
    public Seller convertToSellerEntity(SellerDto sellerDto) {
        Seller seller = new Seller();
        if (sellerDto != null) {
            BeanUtils.copyProperties(sellerDto, seller);
        }
        return seller;
    }

    // convert from seller entity to seller dto
    public SellerDto convertToSellerDto(Seller seller) {
        SellerDto sellerDto = new SellerDto();
        if (seller != null) {
            BeanUtils.copyProperties(seller, sellerDto);
        }
        return sellerDto;
    }
}

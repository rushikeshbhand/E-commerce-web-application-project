package com.ewa.project.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ewa.project.entity.Admin;
import com.ewa.project.model.AdminDto;

@Component // Indicates that this class is a Spring component
public class AdminConverter {

    // convert from admin dto to admin entity
    public Admin convertToAdminEntity(AdminDto adminDto) {
        Admin admin = new Admin();
        if (adminDto != null) {
            BeanUtils.copyProperties(adminDto, admin);
        }
        return admin;
    }

    // convert from admin entity to admin dto
    public AdminDto convertToAdminDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        if (admin != null) {
            BeanUtils.copyProperties(admin, adminDto);
        }
        return adminDto;
    }
}

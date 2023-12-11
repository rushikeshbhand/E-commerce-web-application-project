package com.ewa.project.converter;

import org.springframework.stereotype.Component;

import com.ewa.project.entity.Admin;
import com.ewa.project.model.AdminDto;

@Component // Indicates that this class is a Spring component
public class AdminConverter {

    // convert from admin dto to admin entity
    public Admin convertToAdminEntity(AdminDto adminDto) {
        Admin admin = new Admin();
        if (adminDto != null) {
        	admin.setAdminId(adminDto.getAdminId());
            admin.setAdminPassword(adminDto.getAdminPassword());
            admin.setAdminEmail(adminDto.getAdminEmail());
            admin.setAdminContact(adminDto.getAdminContact());
        }
        return admin;
    }

    // convert from admin entity to admin dto
    public AdminDto convertToAdminDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        if (admin != null) {
        	adminDto.setAdminId(admin.getAdminId());
            adminDto.setAdminPassword(admin.getAdminPassword());
            adminDto.setAdminEmail(admin.getAdminEmail());
            adminDto.setAdminContact(admin.getAdminContact());
        }
        return adminDto;
    }
}

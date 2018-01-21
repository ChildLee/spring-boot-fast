package com.fast.controller;

import com.fast.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("public/admin")
    public String getAdminAll() {
        return "不需要登陆就能访问";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("admin")
    public String getAdmin() {
        return adminService.getAdmin();
    }


    @GetMapping("admin/admin")
    public String getUser() {
        return "admin权限";
    }
}

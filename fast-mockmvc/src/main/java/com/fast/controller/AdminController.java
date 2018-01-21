package com.fast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("admin")
    public String getAdmin(String username, String password) {
        return "账号:" + username + "\n密码:" + password;
    }
}

package com.fast.controller;

import com.fast.entity.SysUser;
import com.fast.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private SysUserRepository sysUserRepository;

    @GetMapping("getUserAll")
    public List<SysUser> getUserAll() {
        return sysUserRepository.findAll();
    }

    @GetMapping("getUser")
    public String getUser() {
        sysUserRepository.findAll();
        return "666";
    }
}

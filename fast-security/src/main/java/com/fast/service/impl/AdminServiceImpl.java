package com.fast.service.impl;

import com.fast.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public String getAdmin() {
        return "权限测试";
    }
}

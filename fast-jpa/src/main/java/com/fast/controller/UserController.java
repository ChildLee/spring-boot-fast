package com.fast.controller;

import com.fast.entity.SysUser;
import com.fast.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private SysUserRepository sysUserRepository;

    @GetMapping("getUserAll")
    public Page<SysUser> getUserAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(1, 1, sort);
        return sysUserRepository.findAll(pageable);
    }
}

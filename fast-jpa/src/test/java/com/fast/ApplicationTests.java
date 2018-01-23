package com.fast;

import com.fast.entity.SysUser;
import com.fast.repository.SysUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTests {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SysUserRepository sysUserRepository;

    @Test
    public void contextLoads() throws IOException {
        SysUser root = sysUserRepository.findByUsername("root");
        System.out.println(root);
        SysUser root1 = sysUserRepository.findByUsernameAndPasswordOrderByPasswordDescIdAsc("root", "root");
        System.out.println(root1);
    }
}

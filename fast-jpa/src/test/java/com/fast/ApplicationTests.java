package com.fast;

import com.fast.entity.SysUser;
import com.fast.repository.SysUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SysUserRepository sysUserRepository;

    @Test
    public void contextLoads() throws IOException {
        List<SysUser> list = sysUserRepository.findAll();
    }

}

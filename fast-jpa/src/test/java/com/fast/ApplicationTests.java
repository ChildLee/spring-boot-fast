package com.fast;

import com.fast.entity.SysUser;
import com.fast.repository.SysUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private SysUserRepository sysUserRepository;

    @Test
    public void contextLoads() {
        SysUser sysUser = sysUserRepository.findByUsername("root");
        System.out.println(sysUser);
    }

}

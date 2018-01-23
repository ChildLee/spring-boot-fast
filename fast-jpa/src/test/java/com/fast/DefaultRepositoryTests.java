package com.fast;

import com.fast.entity.SysUser;
import com.fast.repository.TextRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DefaultRepositoryTests {

    @Autowired
    private TextRepository textRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private SysUser sysUser;

    @Before
    public void init() {
        sysUser = new SysUser();
        sysUser.setUsername("root");
        sysUser.setPassword("root");
    }

    @Test
    public void defaultTest() throws JsonProcessingException {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(0, 1, sort);
        Page<SysUser> page = textRepository.findAll(pageable);
        String s = mapper.writeValueAsString(page);
        System.out.println(s);
    }
}

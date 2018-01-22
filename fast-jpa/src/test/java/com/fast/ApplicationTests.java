package com.fast;

import com.fast.entity.SysUser;
import com.fast.repository.TextRepository;
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
    @Autowired
    private TextRepository textRepository;

    @Test
    public void contextLoads() throws IOException {
        List<SysUser> list = textRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String jsonfromList = mapper.writeValueAsString(list);
        System.out.println(jsonfromList);

        List<SysUser> stuList2 = mapper.readValue(jsonfromList, List.class);
        System.out.println(stuList2);
    }

}

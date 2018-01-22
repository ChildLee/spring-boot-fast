package com.fast;

import com.fast.repository.TextRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultRepositoryTests {
    @Autowired
    private TextRepository textRepository;

    @Test
    public void efaultTest() {
        textRepository.findAll();
        textRepository.findOne((long) 1);
    }
}

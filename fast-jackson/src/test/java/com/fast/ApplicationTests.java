package com.fast;

import com.fast.entity.SysRole;
import com.fast.entity.SysUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private List<SysUser> list;

    private Map<String, Object> map;

    @Before
    public void init() {
        SysRole role = new SysRole();
        role.setId((long) 1);
        role.setName("ROLE_USER");

        List<SysRole> sysRoles = new ArrayList<>();
        sysRoles.add(role);

        SysUser sysUser = new SysUser();
        sysUser.setId((long) 1);
        sysUser.setUsername("root");
        sysUser.setPassword("root");
        sysUser.setRoles(sysRoles);

        list = new ArrayList<>();
        list.add(sysUser);

        map = new HashMap<>();
        map.put("sysUser", sysUser);
        map.put("class", "ClassName");
    }

    @Test
    public void contextLoads() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //List to JSON
        String listJson = mapper.writeValueAsString(list);
        System.out.println("List to JSON");
        System.out.println(listJson);

        //JSON to List
        List<SysUser> sysUser = mapper.readValue(listJson, List.class);
        System.out.println("JSON to List");
        System.out.println(sysUser);

        //Map to JSON
        String mapJson = mapper.writeValueAsString(map);
        System.out.println("Map to JSON");
        System.out.println(mapJson);

        //JSON to Map
        Map<String, Object> mapObj = mapper.readValue(mapJson, Map.class);
        System.out.println("JSON to Map");
        System.out.println(mapObj);
    }

}

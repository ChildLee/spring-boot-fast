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

    private SysUser sysUser;

    private Map<String, Object> map;

    private SysUser[] sysUsersArr;

    @Before
    public void init() {
        SysRole role = new SysRole();
        role.setId((long) 1);
        role.setName("ROLE_USER");

        List<SysRole> sysRoles = new ArrayList<>();
        sysRoles.add(role);

        sysUser = new SysUser();
        sysUser.setId((long) 1);
        sysUser.setUsername("root");
        sysUser.setPassword("root");
        sysUser.setRoles(sysRoles);

        list = new ArrayList<>();
        list.add(sysUser);

        map = new HashMap<>();
        map.put("sysUser", sysUser);
        map.put("class", "ClassName");

        sysUsersArr = new SysUser[]{sysUser, sysUser};
    }

    @Test
    public void contextLoads() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //Obj to JSON
        String objJson = mapper.writeValueAsString(sysUser);
        System.out.println("Obj to JSON");
        System.out.println(objJson);

        //JSON to Obj
        SysUser jsonObj = mapper.readValue(objJson, SysUser.class);
        System.out.println("JSON to Obj");
        System.out.println(sysUser);

        //List to JSON
        String listJson = mapper.writeValueAsString(list);
        System.out.println("List to JSON");
        System.out.println(listJson);

        //JSON to List
        List<SysUser> jsonList = mapper.readValue(listJson, List.class);
        System.out.println("JSON to List");
        System.out.println(jsonList);

        //Map to JSON
        String mapJson = mapper.writeValueAsString(map);
        System.out.println("Map to JSON");
        System.out.println(mapJson);

        //JSON to Map
        Map<String, Object> jsonMap = mapper.readValue(mapJson, Map.class);
        System.out.println("JSON to Map");
        System.out.println(jsonMap);

        //objArray to JSON
        String objArray = mapper.writeValueAsString(sysUsersArr);
        System.out.println("objArray to JSON");
        System.out.println(objArray);

        //JSON to objArray
        SysUser[] arrayObj = mapper.readValue(objArray, SysUser[].class);
        System.out.println("JSON to objArray");
        System.out.println(arrayObj);
    }

}

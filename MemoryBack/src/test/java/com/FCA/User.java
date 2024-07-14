package com.FCA;

import com.FCA.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class User {
    @Resource
    private UserMapper userMapper;
    @Test
    void User(){
        List<com.FCA.domain.User> users = userMapper.selectAllUser();
        System.out.println(users);
        String property = System.getProperty("user.dir");
        System.out.println(property);

    }

    @Test
    void addUser(){
        com.FCA.domain.User user = new com.FCA.domain.User();
        user.setUserName("xx551");
        user.setPassWord("111");
        int add = userMapper.add(user);
        System.out.println(user.getUserId());
    }
    @Test
    void addUserImage(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        userMapper.addUserImage(1,list);
    }

}

package com.atguigu.test;

import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.xml.transform.Source;
import java.sql.Connection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource(){
        Class<? extends DataSource> connection = dataSource.getClass();
        System.out.println(connection);
    }

    @Test
    public void testFindAll(){
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}

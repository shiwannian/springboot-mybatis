package com.atguigu.service;

import com.atguigu.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> findAll();

    List<User> findUsers();

    User findUserbyId(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);
}

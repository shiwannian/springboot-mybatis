package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //@Autowired Spring提供的
    @Resource//JDK提供的依赖注入
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;




    //@Transactional(readOnly = true)
    @Override
    public List<User> findAll() {

        //redis的key
        String key = "alluser";

        //先查询redis中是否有数据，如果有直接返回redis的数据
        List<User> users = (List<User>) redisTemplate.boundValueOps(key).get();
        if(users != null){
            System.out.println("从Redis中获取缓存数据 = " + users);
            return users;
        }

        //如果没有，查询数据库
         users = userDao.findAll();

        //将数据库数据存入到redis中
        if(users != null && users.size() > 0){
            System.out.println("从数据库中获取存放的数据");
            redisTemplate.boundValueOps(key).set(users);
        }
        return users;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<User> findUsers() {
        return userDao.findAll();
    }

    //根据id查询
    @Override
    public User findUserbyId(Integer id) {
        return  userDao.findById(id).get();
    }

    //保存
    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    //更新
    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    //根据id删除
    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteById(id);
    }
}

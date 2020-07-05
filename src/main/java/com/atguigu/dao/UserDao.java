package com.atguigu.dao;

import com.atguigu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Mapper标记该类是一个mybatis的mapper注解，可以被springBoot自动扫描到spring上下文中 加mapper就不可不用扫描，负责必须扫描
@Mapper
public interface UserDao extends JpaRepository<User,Integer> {

    //注解版，不用写xml配置文件了
    //@Select("select * from user")
    public List<User> findAll();
}

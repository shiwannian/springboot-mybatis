package com.atguigu.controller;

import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//@RestController //组合了@Controller 和@ResponBody注解
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello","hello welcome");

        //集合数据
        List<User> users = new ArrayList<>();
        users.add(new User("张三","123","张三"));
        users.add(new User("李四","123","李四"));
        users.add(new User("王五","123","王五"));
        model.addAttribute("users",users);
        return "demo1";
    }

    /***
     * 访问/user/hello1  跳转到demo1页面
     */
    @RequestMapping("/hello1")
    public String hello1(Model model){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("No","123");
        dataMap.put("address","深圳");
        model.addAttribute("dataMap",dataMap);
        return "demo1";
    }


    /***
     * 访问/user/hello2  跳转到demo1页面
     */
    @RequestMapping("/hello2")
    public String hello2(Model model){
        //存储一个数组
        String[] names = {"张三","李四","王五"};
        model.addAttribute("names",names);
        return "demo1";
    }

    /***
     * 访问/user/hello  跳转到demo1页面
     */
    @RequestMapping("/hello3")
    public String hello3(Model model){
        //日期
        model.addAttribute("now",new Date());
        return "demo1";
    }

    /***
     * 访问/user/hello4  跳转到demo1页面
     */
    @RequestMapping("/hello4")
    public String hello4(Model model){
        //if条件
        model.addAttribute("age",22);
        return "demo1";
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        //这里有事务就打印的是代理类
        System.out.println(userService.getClass());//class com.sun.proxy.$Proxy67
        return userService.findAll();
    }

    @RequestMapping("/findUsers")
    public List<User> findUsers(){
        return userService.findUsers();
    }

    @RequestMapping("/findUserById/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findUserbyId(id);
    }
    @RequestMapping("/saveUser")
    public void saveUser(User user) {
        userService.saveUser(user);
    }
    @RequestMapping("/updateUser")
    public void updateUser(User user) {
        userService.updateUser(user);
    }
    @RequestMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable("id")  Integer id) {
        userService.deleteUserById(id);
    }


}

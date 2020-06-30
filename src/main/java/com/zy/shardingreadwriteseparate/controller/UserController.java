package com.zy.shardingreadwriteseparate.controller;

import com.zy.shardingreadwriteseparate.entity.User;
import com.zy.shardingreadwriteseparate.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZY
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/save")
    public User save(User user){
        return userService.save(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }

}

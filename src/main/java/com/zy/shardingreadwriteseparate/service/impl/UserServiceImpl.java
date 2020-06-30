package com.zy.shardingreadwriteseparate.service.impl;

import com.zy.shardingreadwriteseparate.dao.UserRepository;
import com.zy.shardingreadwriteseparate.entity.User;
import com.zy.shardingreadwriteseparate.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZY
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userDao;


    /**
     * 保存实体
     *
     * @param user 用于保存的实体
     */
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    /**
     * 获取所有实体
     *
     * @return 返回用户列表
     */
    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }
}

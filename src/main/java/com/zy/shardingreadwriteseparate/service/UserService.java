package com.zy.shardingreadwriteseparate.service;

import com.zy.shardingreadwriteseparate.entity.User;

import java.util.List;

/**
 * @author ZY
 */
public interface UserService {

    /**
     * 保存实体
     * @param user 用于保存的实体
     */
    User save(User user);

    /**
     * 获取所有实体
     * @return 返回用户列表
     */
    List<User> getAllUser();
}

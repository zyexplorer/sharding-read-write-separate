package com.zy.shardingreadwriteseparate.dao;

import com.zy.shardingreadwriteseparate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZY
 */
public interface UserRepository extends JpaRepository<User, Long> {

}

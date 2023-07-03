package com.hqyj.gwr.mapper;

import com.hqyj.gwr.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.hqyj.gwr.pojo.User
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    int insertUser(User user);
}





package com.hqyj.gwr.service;

import com.hqyj.gwr.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hqyj.gwr.util.ResultInfo;

/**
 *
 */
public interface UserService{

    ResultInfo login(String username, String password);

    ResultInfo goRegister(String username, String password, String perm, String role);
}

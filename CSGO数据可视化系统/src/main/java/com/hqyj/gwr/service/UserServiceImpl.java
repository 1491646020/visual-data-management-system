package com.hqyj.gwr.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hqyj.gwr.pojo.User;
import com.hqyj.gwr.service.UserService;
import com.hqyj.gwr.mapper.UserMapper;
import com.hqyj.gwr.util.ResultInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public ResultInfo login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        //zhangsan123456
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return new ResultInfo(200,"登陆成功",(User)subject.getPrincipal());
        } catch (UnknownAccountException e) {
            //用户名不存在
            return new ResultInfo(500,"用户名不存在",null);
        }catch (IncorrectCredentialsException e){
            //密码错误的情况
            return new ResultInfo(500,"密码错误",null);
        }
    }

    @Override
    public ResultInfo goRegister(String username, String password, String perm, String role) {

        int insert = userMapper.insertUser(new User(32, username, password, perm, role));
        if(insert==1){
            return new ResultInfo(200,"新增用户成功",insert);
        }
        return new ResultInfo(500,"新增用户失败",null);
    }
}





package com.hqyj.gwr.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hqyj.gwr.mapper.UserMapper;
import com.hqyj.gwr.pojo.User;
import com.hqyj.gwr.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Service;
import java.util.HashSet;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;
    /*
    * 授权
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //拿到认证时的User对象
        User loginUser = (User)SecurityUtils.getSubject().getSession().getAttribute("loginUser");
        //拿到角色和权限信息
        String role = loginUser.getRole();
        String perm = loginUser.getPerm();
        HashSet<String> roles = new HashSet<>();
        roles.add(role);
        HashSet<String> perms = new HashSet<>();
        perms.add(perm);
        //返回一个装有权限和角色信息的info
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(perms);
        return info;
    }
/*
* 认证
* */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
         //先将其转换成UsernamePasswordToken从而得到username
        UsernamePasswordToken token= (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        //使用username作为条件查询数据库
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        //如果user不为空，数据库中就有该数据
        if(user!=null){
            //todo
            SecurityUtils.getSubject().getSession().setAttribute("loginUser",user);
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        }
        throw  new UnknownAccountException();
    }
}

package com.hqyj.gwr.config;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


//手动添加securityManager到shirofilter当中去
@Configuration
public class ShiroConfig {
    //将realm先添加到容器当中
    @Bean
    public MyRealm realm(){
//        todo
        return new MyRealm();
    }
    //添加securityManager到容器当中
    @Bean
    public DefaultWebSecurityManager dwm(@Qualifier("realm") MyRealm realm){
        //手动添加realm到SecurityManage当中去
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    /*
     * 开启Shiro注解(如@RequiresRoles,@RequiresPermissions),
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     */

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
    @Bean
    public ShiroFilterFactoryBean bean(@Qualifier("dwm")DefaultWebSecurityManager manager){
        //将要在此处指明要过滤些什么
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //登录界面（没有登录强行跳转返回的界面）
        bean.setLoginUrl("/");
        //没有权限去往的界面
        bean.setUnauthorizedUrl("/goError");
        //定义一个map用于专门存放哪些权限可以做哪些事情
        HashMap<String, String> map = new HashMap<>();
        //认证（登录）以后才能访问
        //设置shiro的拦截规则
        //anon 匿名用户可访问   authc  认证用户可访问
        //user 使用RemeberMe的用户可访问  perms  对应权限可访问
        //role  对应的角色可访问
//        map.put("/goRegister","anon");
        map.put("/goIndex","anon");
        map.put("/","anon");

//        map.put("/goWeaponAdd","authc");
//        map.put("/deleteOneByWeaponId","roles[admin]");
//        map.put("/goWeaponEdit","authc");


//        map.put("/goWeaponAdd","perms[add],roles[admin]");
//        map.put("/deleteOneByWeaponId","perms[delete],roles[admin]");
//        map.put("/goWeaponEdit","perms[update],roles[admin]");
//        map.put("/goWeaponAdd","");
//        map.put("/deleteOneByWeaponId","roles[admin]");
//        map.put("/goWeaponEdit","roles[admin]");



        bean.setFilterChainDefinitionMap(map);
        return bean;
    }
}

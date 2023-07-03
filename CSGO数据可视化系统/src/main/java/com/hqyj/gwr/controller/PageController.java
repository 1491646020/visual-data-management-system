package com.hqyj.gwr.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//专门用于页面的跳转
//标注它为一个控制器
@Controller
public class PageController {

    @RequestMapping("/weaponList")
    public String weaponList() {
        return "weapon-list";
    }
    @RequiresPermissions(value = {"add","update","delete"},logical = Logical.OR)
    @RequiresRoles(value = {"admin"},logical = Logical.OR)
    @RequestMapping("/goWeaponAdd")
    public String goWeaponAdd() {
        return "weapon-add";
    }

    @RequiresPermissions(value = "update",logical = Logical.OR)
    @RequiresRoles(value = {"admin"},logical = Logical.OR)
    @RequestMapping("/goWeaponEdit")
    public String goWeaponEdit() {
        return "weapon-edit";
    }

    //默认欢迎页面修改为login.html
    @RequestMapping("/")
    public String goLogin() {
        return "login";
    }

    //默跳转到index页面的方法
    @RequestMapping("/goIndex")
    public String goIndex() {
        return "index";
    }

    //默跳转到index页面的方法
    @RequestMapping("/goError")
    public String goError() {
        return "error";
    }


    @RequestMapping("/goRegister")
    public String goRegister() {
        return "register";
    }

}

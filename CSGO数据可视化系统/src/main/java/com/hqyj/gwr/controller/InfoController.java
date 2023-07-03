package com.hqyj.gwr.controller;

import com.hqyj.gwr.pojo.WeaponInfo;
import com.hqyj.gwr.service.UserService;
import com.hqyj.gwr.service.WeaponInfoService;
import com.hqyj.gwr.util.ResultInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfoController {
    @Autowired
    WeaponInfoService weaponInfoService;

    @Autowired
    UserService userService;


    @GetMapping("/selectWeaponNums")
    public ResultInfo selectHeroNums(){
        return weaponInfoService.selectWeaponNums();
    }


    @GetMapping("/selectDaggerNums")
    public ResultInfo selectDaggerNums(){
        return weaponInfoService.selectDaggerNums();
    }



    @GetMapping("/selectPistolNums")
    public ResultInfo selectPistolNums(){
        return weaponInfoService.selectPistolNums();
    }



    @GetMapping("/selectRifleNums")
    public ResultInfo selectRifleNums(){
        return weaponInfoService.selectRifleNums();
    }



    @GetMapping("/selectHeavyWeaponNums")
    public ResultInfo selectHeavyWeaponNums(){
        return weaponInfoService.selectHeavyWeaponNums();
    }


    @GetMapping("/selectNumsWeaponKind")
    public ResultInfo selectNumsWeaponKind(){
        return weaponInfoService.selectNumsWeaponKind();
    }


    @GetMapping("/selectAllWeaponsByPage")
    public ResultInfo selectAllWeaponsByPage(Integer currentPage,Integer currentSize,String name){
        return weaponInfoService.selectAllWeaponsByPage(currentPage,currentSize,name);
    }

    @RequiresPermissions(value = "delete",logical = Logical.OR)
    @RequiresRoles(value = {"admin"},logical = Logical.OR)
    @DeleteMapping("/deleteOneByWeaponId")
    public ResultInfo deleteOneByWeaponId(Integer weaponId){
        return weaponInfoService.deleteOneByWeaponId(weaponId);
    }

    @PostMapping("/addWeapon")
    public ResultInfo addWeapon(WeaponInfo weaponInfo){
        return weaponInfoService.addWeapon(weaponInfo);
    }

    @PostMapping("/goRegister")
    public ResultInfo goRegister(String username,String password,String perm,String role){
        return userService.goRegister(username,password,perm,role);
    }


    @PostMapping("/editWeapon")
    public ResultInfo editWeapon(WeaponInfo weaponInfo){
        return weaponInfoService.editWeapon(weaponInfo);
    }


    @GetMapping("/selectTop5AttackRang")
    public ResultInfo selectTop5AttackRang(){
        return weaponInfoService.selectTop5AttackRang();
    }

    @GetMapping("/selectTop5Sole")
    public ResultInfo selectTop5Sole(){
        return weaponInfoService.selectTop5Sole();
    }

    @GetMapping("/selectTop5AttackDamage")
    public ResultInfo selectTop5AttackDamage(){
        return weaponInfoService.selectTop5AttackDamage();
    }

    @PostMapping("/login")
    public ResultInfo login(String username,String password){
        return userService.login(username,password);
    }


}

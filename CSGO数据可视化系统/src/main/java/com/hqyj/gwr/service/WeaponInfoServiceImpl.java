package com.hqyj.gwr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hqyj.gwr.mapper.WeaponMapper;
import com.hqyj.gwr.pojo.WeaponInfo;
import com.hqyj.gwr.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//标注其为一个service类
@Service
public class WeaponInfoServiceImpl implements WeaponInfoService {


    @Autowired
    WeaponMapper weaponMapper;

    @Override
    public ResultInfo selectWeaponNums() {
        Integer i = weaponMapper.selectCount(null);
        return new ResultInfo(200,"查询成功",i);
    }

    @Override
    public ResultInfo selectDaggerNums() {
        QueryWrapper<WeaponInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("item_slot_sc","匕首");
        Integer i = weaponMapper.selectCount(wrapper);
        return new ResultInfo(200,"查询成功",i);
    }

    @Override
    public ResultInfo selectPistolNums() {
        QueryWrapper<WeaponInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("item_slot_sc","手枪");
        Integer i = weaponMapper.selectCount(wrapper);
        return new ResultInfo(200,"查询成功",i);
    }

    @Override
    public ResultInfo selectRifleNums() {
        QueryWrapper<WeaponInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("item_slot_sc","步枪");
        Integer i = weaponMapper.selectCount(wrapper);
        return new ResultInfo(200,"查询成功",i);
    }

    @Override
    public ResultInfo selectHeavyWeaponNums() {
        QueryWrapper<WeaponInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("item_slot_sc","重型武器");
        Integer i = weaponMapper.selectCount(wrapper);
        return new ResultInfo(200,"查询成功",i);
    }

    @Override
    public ResultInfo selectNumsWeaponKind() {
        QueryWrapper<WeaponInfo> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("item_slot_sc","匕首");
        Integer bs = weaponMapper.selectCount(wrapper1);

        QueryWrapper<WeaponInfo> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("item_slot_sc","手枪");
        Integer sq = weaponMapper.selectCount(wrapper2);

        QueryWrapper<WeaponInfo> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("item_slot_sc","步枪");
        Integer bq = weaponMapper.selectCount(wrapper3);

        QueryWrapper<WeaponInfo> wrapper4 = new QueryWrapper<>();
        wrapper4.eq("item_slot_sc","重型武器");
        Integer zxwq = weaponMapper.selectCount(wrapper4);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("bs",bs);
        map.put("sq",sq);
        map.put("bq",bq);
        map.put("zxwq",zxwq);

        return new ResultInfo(200,"查询成功",map);
    }

    @Override
    public ResultInfo selectAllWeaponsByPage(Integer currentPage,Integer currentSize,String name) {
        //新建一个page对象(空)，将前端传回来的当前页和当前页能够存放的最大数据数给放进来
        Page<WeaponInfo> weaponInfoPage = new Page<>(currentPage,currentSize);
        //定义一个条件构造器用来模糊查询
        QueryWrapper<WeaponInfo> wrapper = new QueryWrapper<>();
        wrapper.like("name_sc",name);
        //selectPage帮我们把分页的记录数（数据），总数等都给计算好以后再传了一个page对象出来
        Page<WeaponInfo> page = weaponMapper.selectPage(weaponInfoPage, wrapper);

        return new ResultInfo(200,"分页查询成功",page);
    }

    @Override
    public ResultInfo deleteOneByWeaponId(Integer weaponId) {
        int i = weaponMapper.deleteById(weaponId);
        if(i>0){
            return new ResultInfo(200,"删除成功",i);
        }
        return new ResultInfo(500,"删除失败",null);
    }

    @Override
    public ResultInfo addWeapon(WeaponInfo weaponInfo) {
        //直接使用mybatisplus中的
//        basemapper中的insert方法插入数据
        int insert = weaponMapper.insert(weaponInfo);
        if(insert==1){
            return new ResultInfo(200,"新增成功",insert);
        }
        return new ResultInfo(500,"新增失败",null);
    }

    @Override
    public ResultInfo editWeapon(WeaponInfo weaponInfo) {
        int i = weaponMapper.updateById(weaponInfo);
        if(i==1){
            return new ResultInfo(200,"修改成功",i);
        }
        return new ResultInfo(500,"修改失败",null);
    }

    @Override
    public ResultInfo selectTop5AttackRang() {
        List<WeaponInfo> weaponInfos =  weaponMapper.selectTop5AttackRang();
        //定义两个集合用于存放每次循环得到的名字和攻击距离
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> accurateRanges = new ArrayList<>();
        for (WeaponInfo weaponInfo : weaponInfos) {
            //存名字
            String name = weaponInfo.getNameSc();
            names.add(name);
            //存攻击距离
            String accurateRange = weaponInfo.getAccurateRange();
            accurateRanges.add(accurateRange);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("names",names);
        map.put("accurateRanges",accurateRanges);
        return new ResultInfo(200,"查询成功",map);
    }

    @Override
    public ResultInfo selectTop5Sole(){
        List<WeaponInfo> weaponInfos =  weaponMapper.selectTop5Sole();
        //定义两个集合用于存放每次循环得到的名字和攻击距离
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
        for (WeaponInfo weaponInfo : weaponInfos) {
            //存名字
            String name = weaponInfo.getNameSc();
            names.add(name);
            //存攻击距离
            Integer price = weaponInfo.getPrice();
            prices.add(price);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("names",names);
        map.put("prices",prices);
        return new ResultInfo(200,"查询成功",map);
    }

    @Override
    public ResultInfo selectTop5AttackDamage(){
        List<WeaponInfo> weaponInfos =  weaponMapper.selectTop5AttackDamage();
        //定义两个集合用于存放每次循环得到的名字和攻击距离
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> damages = new ArrayList<>();
        for (WeaponInfo weaponInfo : weaponInfos) {
            //存名字
            String name = weaponInfo.getNameSc();
            names.add(name);
            //存攻击距离
            Integer damage = weaponInfo.getDamage();
            damages.add(damage);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("names",names);
        map.put("damages",damages);
        return new ResultInfo(200,"查询成功",map);
    }
}

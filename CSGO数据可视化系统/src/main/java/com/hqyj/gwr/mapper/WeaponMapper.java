package com.hqyj.gwr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hqyj.gwr.pojo.WeaponInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponMapper extends BaseMapper<WeaponInfo> {
    List<WeaponInfo> selectTop5AttackRang();

    List<WeaponInfo> selectTop5Sole();

    List<WeaponInfo> selectTop5AttackDamage();
}

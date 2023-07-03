package com.hqyj.gwr.service;

import com.hqyj.gwr.pojo.WeaponInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hqyj.gwr.util.ResultInfo;

/**
 * @author 谭青青
 * @description 针对表【wuqi】的数据库操作Service
 * @createDate 2023-06-30 09:09:29
 */
public interface WeaponInfoService {

    ResultInfo selectWeaponNums();

    ResultInfo selectDaggerNums();

    ResultInfo selectPistolNums();

    ResultInfo selectRifleNums();

    ResultInfo selectHeavyWeaponNums();

    ResultInfo selectNumsWeaponKind();

    ResultInfo selectAllWeaponsByPage(Integer currentPage, Integer currentSize, String name);

    ResultInfo deleteOneByWeaponId(Integer weaponId);

    ResultInfo addWeapon(WeaponInfo weaponInfo);

    ResultInfo editWeapon(WeaponInfo weaponInfo);

    ResultInfo selectTop5AttackRang();

    ResultInfo selectTop5Sole();

    ResultInfo selectTop5AttackDamage();
}

package com.hqyj.gwr.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName wuqi
 */
@TableName(value ="wuqi")
//相当于getter and setter
@Data
//全参构造
@AllArgsConstructor
//无参构造
@NoArgsConstructor
public class WeaponInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String nameSc;

    /**
     * 
     */
    private String descriptionSc;

    /**
     * 
     */
    private String itemSlotSc;

    /**
     * 
     */
    private String accurateRange;

    /**
     * 
     */
    private String killAwardPercentage;

    /**
     * 
     */
    private Integer price;

    /**
     * 
     */
    private Integer clipSizeMax;

    /**
     * 
     */
    private Integer cycleTime;

    /**
     * 
     */
    private Integer damage;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/6 11:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gtype implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    private String gtypename;
    private Date createtime=new Date();
    private Integer status;

    @TableField(exist = false)
    private String gtname;

}

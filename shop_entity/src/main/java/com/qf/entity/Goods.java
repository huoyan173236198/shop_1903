package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/5 16:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String gname;
    private String ginfo;
    private String gimage;
    private BigDecimal gprice;
    private Integer tid;
    private Integer gsave;

}

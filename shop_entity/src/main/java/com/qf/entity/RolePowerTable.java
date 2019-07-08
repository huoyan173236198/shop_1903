package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/2 16:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePowerTable implements Serializable {
    private Integer rid;
    private Integer pid;

}
